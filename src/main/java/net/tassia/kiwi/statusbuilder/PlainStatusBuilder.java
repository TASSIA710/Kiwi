package net.tassia.kiwi.statusbuilder;

import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Status;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PlainStatusBuilder implements StatusBuilder {

	private final Map<String, String> headers;

	public PlainStatusBuilder() {
		this.headers = new HashMap<>();
		// TODO: ContentType
	}

	@Override
	public Response buildStatusPage(Status status) {
		return Response.generateBasicResponse(status, headers, status.getStatusText().getBytes(StandardCharsets.UTF_8));
	}

}
