package net.tassia.kiwi.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;
import net.tassia.kiwi.HttpStatus;
import net.tassia.kiwi.Kiwi;
import net.tassia.kiwi.views.HttpView;

import java.io.IOException;

public abstract class JsonApiRoute<T> implements HttpBasicRoute {
	public static final String CONTENT_TYPE = "application/json; charset=utf-8";
	private final Class<T> requestStructure;

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
	 * TODO
	 */
	public abstract Object onApiRequest(Kiwi kwi, HttpRequest request, HttpResponse response, String[] matches, T payload);

}
