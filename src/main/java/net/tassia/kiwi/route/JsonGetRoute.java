package net.tassia.kiwi.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.Server;
import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.media.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * A JSON route is a route, that returns an object as output.
 */
public abstract class JsonGetRoute implements Route {

	private final Map<String, String> headers;
	private final ObjectMapper objectMapper;

	public JsonGetRoute() {
		this.headers = new HashMap<>();
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public Response process(Server server, Request request, String[] matches) {
		// Variables
		Response response = Response.buildResponse(Status.STATUS_200, null, headers);

		// Process
		Object output = process(server, request, matches, response);

		// Prepare response
		try {
			response.setMediaType(new MediaType(MediaType.APPLICATION_JSON));
			response.setPayload(objectMapper.writeValueAsString(output).getBytes(MediaType.ASCII));
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			return server.getStatusBuilder().buildStatusPage(Status.STATUS_500);
		}

		// Send response
		return response;
	}

	public abstract Object process(Server server, Request request, String[] matches, Response response);

}
