package net.tassia.kiwi.middleware;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;

public abstract class ResponseMiddleware extends Middleware {

	@Override
	public boolean isRequestMiddleware() {
		return false;
	}

	@Override
	public boolean applyToRequest(HttpRequest request, HttpResponse response) {
		return true;
	}

	@Override
	public boolean isResponseMiddleware() {
		return true;
	}

}
