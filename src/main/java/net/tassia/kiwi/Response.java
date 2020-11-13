package net.tassia.kiwi;

import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.enums.Version;

import java.io.OutputStream;
import java.util.Map;

public abstract class Response extends MimeMessage {

	public abstract Version getVersion();
	public abstract Status getStatus();

	public abstract byte[] getPayload();
	public abstract void setPayload(byte[] payload);

	public static Response generateBasicResponse(Status status, Map<String, String> headers, byte[] payload) {
		return new Response() {
			private Map<String, String> h = headers;
			@Override
			public Version getVersion() {
				return null;
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

			}
			@Override
			public void setHeaders(Map<String, String> headers) {
				this.h = headers;
			}
			@Override
			public Map<String, String> getHeaders() {
				return h;
			}
			@Override
			public void setHeader(String header, String value) {
				h.put(header, value);
			}
			@Override
			public void unsetHeader(String header) {
				h.remove(header);
			}
			@Override
			public String getHeader(String key) {
				return h.get(key);
			}
			@Override
			public boolean hasHeader(String key) {
				return h.containsKey(key);
			}
		};
	}

}
