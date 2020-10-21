package net.tassia.kiwi.middleware;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;

/**
 * Manages data created by middleware for HTTP requests and responses.
 */
public class MiddlewareData<T extends Middleware> {

	private final T source;
	private final HttpRequest request;
	private final HttpResponse response;

	/**
	 * Creates a new middleware data.
	 * @param source the source middleware
	 * @param request the HTTP request
	 * @param response the HTTP response
	 */
	public MiddlewareData(T source, HttpRequest request, HttpResponse response) {
		this.source = source;
		this.request = request;
		this.response = response;
	}

	/**
	 * The middleware that created this data.
	 * @return the source middleware
	 */
	public T getSource() {
		return source;
	}

	/**
	 * The HTTP request this data is linked to.
	 * @return the request
	 */
	public HttpRequest getRequest() {
		return request;
	}

	/**
	 * The HTTP response this data is linked to.
	 * @return the response
	 */
	public HttpResponse getResponse() {
		return response;
	}

}
