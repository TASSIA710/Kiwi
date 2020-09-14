package net.tassia.kiwi;

public abstract class HttpRequest implements HasHeaders {

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

}
