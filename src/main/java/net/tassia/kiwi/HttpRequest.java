package net.tassia.kiwi;

import java.util.HashMap;
import java.util.Map;

public abstract class HttpRequest {
	private final Map<String, String[]> headers;

	/* Constructor */
	public HttpRequest() {
		this.headers = new HashMap<>();
	}
	/* Constructor */





	/* Headers */
	public Map<String, String[]> getHeaders() {
		return headers;
	}

	public String getHeader(String name) {
		String[] h = getHeaders(name);
		return h != null && h.length > 0 ? h[0] : null;
	}

	public String[] getHeaders(String name) {
		return headers.get(name);
	}
	/* Headers */





	/* Abstract Methods */
	/**
	 * TODO
	 */
	public abstract HttpMethod getMethod();

	/**
	 * TODO
	 */
	public abstract boolean isMethod(HttpMethod method);

	/**
	 * TODO
	 */
	public abstract HttpVersion getHttpVersion();

	/**
	 * TODO
	 */
	public abstract String getFullPath();

	/**
	 * TODO
	 */
	public abstract String getPath();

	/**
	 * TODO
	 */
	public abstract String getQueryString();

	/**
	 * TODO
	 */
	public abstract byte[] getPayload();
	/* Abstract Methods */

}
