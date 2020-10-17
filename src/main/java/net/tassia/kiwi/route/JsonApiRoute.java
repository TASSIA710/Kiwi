package net.tassia.kiwi.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;
import net.tassia.kiwi.HttpStatus;
import net.tassia.kiwi.Kiwi;

import java.io.IOException;

/**
 * This is a full JSON route. If this route takes any input bodies (e.g. on POST or PUT requests), it must be
 * JSON data matching the request type class.
 * @param <T> the request type class
 */
public abstract class JsonApiRoute<T> implements HttpBasicRoute {
	public static final String CONTENT_TYPE = "application/json; charset=utf-8";
	private final Class<T> requestStructure;

	/**
	 * Creates a new JSON api route with the given request type class.
	 * @param requestStructure the request type class
	 */
	public JsonApiRoute(Class<T> requestStructure) {
		this.requestStructure = requestStructure;
	}

	@Override
	public byte[] process(Kiwi kiwi, HttpRequest request, HttpResponse response, String[] matches) {
		// Fetch payload
		T req;
		if (request.getPayload() != null) {
			try {
				req = kiwi.getMapper().readValue(request.getPayload(), requestStructure);
			} catch (IOException ex) {
				return response.setStatus(HttpStatus.STATUS_400);
			}
		} else {
			req = null;
		}

		// Process request
		Object res = onApiRequest(kiwi, request, response, matches, req);
		if (res == null) return null;

		// Generate JSON
		byte[] data;
		try {
			data = kiwi.getMapper().writeValueAsBytes(res);
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			return response.setStatus(HttpStatus.STATUS_500);
		}

		// Send response
		response.setHeader("Content-Type", CONTENT_TYPE);
		return data;
	}

	/**
	 * Processes this JSON request.
	 * @param kiwi main
	 * @param request the request
	 * @param response the response
	 * @param matches the matches if the route regex specified any groups
	 * @param payload the payload, or <code>null</code> if no payload was supplied
	 * @return response
	 */
	public abstract Object onApiRequest(Kiwi kiwi, HttpRequest request, HttpResponse response, String[] matches, T payload);

}
