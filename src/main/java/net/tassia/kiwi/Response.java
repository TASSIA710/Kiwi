package net.tassia.kiwi;

import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.enums.Version;

import java.io.OutputStream;
import java.util.Map;

public abstract class Response extends MimeMessage {

	public abstract Status getStatus();

	public abstract byte[] getPayload();
	public abstract void setPayload(byte[] payload);



	public static Response buildResponse(Status status, byte[] payload, Map<String, String> headers) {
		return new BasicResponse(status, payload, headers);
	}

	private static class BasicResponse extends Response {

		private final Status status;
		private byte[] payload;
		private Map<String, String> headers;

		private BasicResponse(Status status, byte[] payload, Map<String, String> headers) {
			this.status = status;
			this.payload = payload;
			this.headers = headers;
		}

		@Override
		public Status getStatus() {
			return status;
		}

		@Override
		public byte[] getPayload() {
			return payload;
		}

		@Override
		public void setPayload(byte[] payload) {
			this.payload = payload;
		}

		@Override
		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}

		@Override
		public Map<String, String> getHeaders() {
			return headers;
		}

		@Override
		public void setHeader(String header, String value) {
			headers.put(header, value);
		}

		@Override
		public void unsetHeader(String header) {
			headers.remove(header);
		}

		@Override
		public String getHeader(String key) {
			return headers.get(key);
		}

		@Override
		public boolean hasHeader(String key) {
			return headers.containsKey(key);
		}

	}

}
