package net.tassia.kiwi;

import java.util.Map;

public abstract class HttpRequest {

	/**
	 * TODO
	 */
	public abstract HttpMethod getMethod();

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
	public abstract Map<String, String[]> getCookies();

	/**
	 * TODO
	 */
	public abstract String getCookie(String name);

	/**
	 * TODO
	 */
	public abstract String[] getCookies(String name);

	/**
	 * TODO
	 */
	public abstract byte[] getPayload();

}
