package net.tassia.kiwi.statusbuilder;

import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.media.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PlainStatusBuilder implements StatusBuilder {

	private final Map<String, String> headers;

	public PlainStatusBuilder() {
		this.headers = new HashMap<>();
		this.headers.put("Content-Type", new MediaType(MediaType.TEXT_PLAIN, MediaType.UTF8).toHeaderString());
	}

	@Override
	public Response buildStatusPage(Status status) {
		return Response.buildResponse(status, status.getStatusText().getBytes(StandardCharsets.UTF_8), headers);
	}

}
