package net.tassia.kiwi.route;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.Server;
import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.media.MediaType;

import java.util.HashMap;
import java.util.Map;

public class StaticRoute implements Route {

	private final Response response;

	public StaticRoute(byte[] payload, MediaType mediaType) {
		this(payload, mediaType, Status.STATUS_200);
	}

	public StaticRoute(byte[] payload, MediaType mediaType, Status status) {
		this.response = Response.buildResponse(status, payload, new HashMap<>());
		this.response.setMediaType(mediaType);
	}

	@Override
	public Response process(Server server, Request request, String[] matches) {
		return response;
	}

	public static StaticRoute fromString(String string) {
		return fromString(string, Status.STATUS_200);
	}

	public static StaticRoute fromString(String string, Status status) {
		MediaType mediaType = new MediaType(MediaType.TEXT_PLAIN, MediaType.UTF8);
		return new StaticRoute(string.getBytes(MediaType.UTF8), mediaType, status);
	}

}
