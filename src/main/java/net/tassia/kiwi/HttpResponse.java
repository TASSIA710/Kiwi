package net.tassia.kiwi;

import java.util.HashMap;
import java.util.Map;

public abstract class HttpResponse implements HasHeaders {
	public static final String ERROR_CONTENT_TYPE = "text/plain; charset=utf-8";
	private int code;
	private byte[] data;
	private final Map<String, String[]> headers;

	/* Constructor */
	/**
	 * TODO
	 */
	public HttpResponse() {
		this.code = 200;
		this.data = new byte[0];
		this.headers = new HashMap<>();
	}
	/* Constructor */





	/* Response Code */
	/**
	 * TODO
	 */
	public int getCode() {
		return code;
	}

	/**
	 * TODO
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * TODO
	 */
	public byte[] error(int code) {
		setCode(code);
		// TODO: Set content-type header
		return "ERROR".getBytes(); // TODO
	}
	/* Response Code */





	/* Response Data */
	/**
	 * TODO
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * TODO
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	/* Response Data */





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

}
