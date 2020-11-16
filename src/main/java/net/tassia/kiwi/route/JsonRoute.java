package net.tassia.kiwi.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.Server;
import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.media.MediaType;
import net.tassia.kiwi.route.Route;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * A JSON route is a route, that takes a predefined object as input, and returns an object as output.
 */
public abstract class JsonRoute<T> implements Route {

	private final Map<String, String> headers;
	private final ObjectMapper objectMapper;
	private final Class<T> requestClass;

	public JsonRoute(Class<T> requestClass) {
		this.headers = new HashMap<>();
		this.objectMapper = new ObjectMapper();
		this.requestClass = requestClass;
	}

	@Override
	public Response process(Server server, Request request, String[] matches) {
		// Variables
		Object output;
		Response response = Response.buildResponse(Status.STATUS_200, null, headers);

		// Validate content-type
		MediaType mediaType = request.getMediaType();
		if (mediaType != null && mediaType.isMimeType(MediaType.APPLICATION_JSON)) {

			// Parse input
			String inputString = new String(request.getPayload(), request.getCharset());
			T input = null;

			// Process
			try {
				input = objectMapper.readValue(inputString, requestClass);
				output = process(server, request, matches, input, response);
			} catch (JsonProcessingException ex) {
				output = new ErrorResponse(ex, ex.getMessage());
				response.setStatus(Status.STATUS_500);
			}

		} else {
			output = new ErrorResponse(null, "Invalid Content-Type.");
		}

		// Prepare response
		byte[] outputBytes;
		try {
			outputBytes = objectMapper.writeValueAsString(output).getBytes(MediaType.ASCII);
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			return server.getStatusBuilder().buildStatusPage(Status.STATUS_500);
		}

		// Send response
		return response;
	}

	public abstract Object process(Server server, Request request, String[] matches, T input, Response response);



	public static class ErrorResponse {

		public Exception error;
		public String message;

		public ErrorResponse(Exception error, String message) {
			this.error = error;
			this.message = message;
		}

	}

}
