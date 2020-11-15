package net.tassia.kiwi.router.basic;

import net.tassia.kiwi.route.Route;

import java.util.regex.Pattern;

class RouteWrapper {

	protected final String path;
	protected final Pattern pattern;
	protected final Route route;

	protected RouteWrapper(String path, Route route) {
		this.path = path;
		this.pattern = Pattern.compile(path);
		this.route = route;
	}

}
