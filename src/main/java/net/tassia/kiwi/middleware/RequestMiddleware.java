package net.tassia.kiwi.middleware;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;

public abstract class RequestMiddleware extends Middleware {

	@Override
	public boolean isRequestMiddleware() {
		return true;
	}

	@Override
	public boolean isResponseMiddleware() {
		return false;
	}

	@Override
	public boolean applyToResponse(HttpRequest request, HttpResponse response) {
		return true;
	}

}
