package net.tassia.kiwi.router;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.route.Route;

public abstract class Router {

	public abstract Response route(Request request);
	public abstract void matches(String regex, Route route, Method...methods);

	public void GET(String regex, Route route) {
		matches(regex, route, Method.GET);
	}

	public void HEAD(String regex, Route route) {
		matches(regex, route, Method.HEAD);
	}

	public void POST(String regex, Route route) {
		matches(regex, route, Method.POST);
	}

	public void PUT(String regex, Route route) {
		matches(regex, route, Method.PUT);
	}

	public void DELETE(String regex, Route route) {
		matches(regex, route, Method.DELETE);
	}

	public void PATCH(String regex, Route route) {
		matches(regex, route, Method.PATCH);
	}

	public void any(String regex, Route route) {
		matches(regex, route, Method.values());
	}

}
