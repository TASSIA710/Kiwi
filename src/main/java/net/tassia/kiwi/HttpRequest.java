package net.tassia.kiwi;

import net.tassia.kiwi.middleware.Middleware;
import net.tassia.kiwi.middleware.MiddlewareData;

import java.util.HashMap;
import java.util.Map;

public abstract class HttpRequest {
	private final Map<String, String[]> headers;
	private final Map<String, MiddlewareData<?>> middlewareData;

	/* Constructor */
	public HttpRequest() {
		this.headers = new HashMap<>();
		this.middlewareData = new HashMap<>();
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





	/* Middleware */
	/**
	 * TODO
	 */
	public <M extends Middleware> void storeMiddlewareData(Class<M> middleware, MiddlewareData<M> data) {
		middlewareData.put(middleware.getName() + ":" + data.getClass().getName(), data);
	}

	/**
	 * TODO
	 */
	public <M extends Middleware, D extends MiddlewareData<M>> D getMiddlewareData(Class<M> middleware, Class<D> data) {
		return (D) middlewareData.get(middleware.getName() + ":" + data.getName());
	}
	/* Middleware */





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
