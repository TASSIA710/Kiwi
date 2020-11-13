package net.tassia.kiwi.driver.basic;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.enums.Version;

import java.util.Map;

class SimpleRequest extends Request {

	private final Method method;
	private final String fullPath;
	private final Version version;
	private final byte[] payload;
	private Map<String, String> headers;

	public SimpleRequest(Method method, String fullPath, Version version, byte[] payload, Map<String, String> headers) {
		this.method = method;
		this.fullPath = fullPath;
		this.version = version;
		this.payload = payload;
		this.headers = headers;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public String getFullRequestPath() {
		return fullPath;
	}

	@Override
	public boolean hasPayload() {
		return payload.length > 0;
	}

	@Override
	public int getPayloadLength() {
		return payload.length;
	}

	@Override
	public byte[] getPayload() {
		return payload;
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
