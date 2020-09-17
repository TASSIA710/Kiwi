package net.tassia.kiwi;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
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
		HttpStatus status = HttpStatus.parseVersion(code);
		if (status != null) {
			return error(status);
		} else {
			setHeader("Content-Type", ERROR_CONTENT_TYPE);
			setCode(code);
			return ("Unknown Error: " + code).getBytes(StandardCharsets.UTF_8);
		}
	}

	/**
	 * TODO
	 */
	public byte[] error(HttpStatus status) {
		setHeader("Content-Type", ERROR_CONTENT_TYPE);
		setCode(status.getCode());
		return status.getStatusLine().getBytes(StandardCharsets.UTF_8);
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

	public void setHeader(String name, String...value) {
		headers.put(name, value);
	}

	public void addHeader(String name, String value) {
		String[] h = headers.get(name);
		if (h == null) {
			setHeader(name, value);
		} else {
			String[] h2 = new String[h.length];
			System.arraycopy(h, 0, h2, 0, h.length);
			h2[h2.length - 1] = value;
			setHeader(name, h2);
		}
	}

	public void clearHeader(String name) {
		headers.remove(name);
	}
	/* Headers */

}
