package net.tassia.kiwi;

import net.tassia.kiwi.views.HttpView;

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
	public byte[] setStatus(HttpStatus status) {
		return setStatus(status, true);
	}

	/**
	 * TODO
	 */
	public byte[] setStatus(HttpStatus status, boolean updateContent) {
		HttpView view = status.getView();
		if (updateContent) {
			set(status.getCode(), view.getData(), view.getContentType(), view.getCharset());
		} else {
			setCode(status.getCode());
		}
		return null;
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

	/**
	 * TODO
	 */
	public void set(int code, byte[] data, String contentType, String charset) {
		setCode(code);
		setData(data);
		setHeader("Content-Type", contentType + "; charset=" + charset);
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
