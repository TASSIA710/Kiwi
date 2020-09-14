package net.tassia.kiwi.middleware;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;

public abstract class Middleware {

	/**
	 * TODO
	 */
	public abstract boolean isRequestMiddleware();

	/**
	 * TODO
	 */
	public abstract boolean applyToRequest(HttpRequest request);

	/**
	 * TODO
	 */
	public abstract boolean isResponseMiddleware();

	/**
	 * TODO
	 */
	public abstract boolean applyToResponse(HttpResponse request);

}
