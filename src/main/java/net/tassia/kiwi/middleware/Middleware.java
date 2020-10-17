package net.tassia.kiwi.middleware;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;

public abstract class Middleware {

	/**
	 * Returns whether this middleware should be applied to requests.
	 * @return apply
	 */
	public abstract boolean isRequestMiddleware();

	/**
	 * Applies this middleware to a request.
	 * @param request the request
	 * @return success return <code>false</code> to prevent further middlewares from being applied to this request
	 */
	public abstract boolean applyToRequest(HttpRequest request);

	/**
	 * Returns whether this middleware should be applied to responses.
	 * @return apply
	 */
	public abstract boolean isResponseMiddleware();

	/**
	 * Applies this middleware to a response.
	 * @param response the response
	 * @return success return <code>false</code> to prevent further middlewares from being applied to this response
	 */
	public abstract boolean applyToResponse(HttpResponse response);

}
