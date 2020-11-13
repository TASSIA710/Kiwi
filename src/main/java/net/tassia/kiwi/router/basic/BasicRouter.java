package net.tassia.kiwi.router.basic;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.route.Route;
import net.tassia.kiwi.router.Router;

import java.util.Stack;
import java.util.regex.Matcher;

public class BasicRouter extends Router {

	private final RouteWrapper[][] routeWrappers = new RouteWrapper[Method.values().length][0];

	@Override
	public Response route(Request request) {
		for (RouteWrapper wrapper : routeWrappers[request.getMethod().ordinal()]) {

			// Prepare path
			String uri = request.getFullRequestPath();
			if (uri.endsWith("/")) uri = uri.substring(0, uri.length() - 1);

			// Valid path?
			if (!uri.matches(wrapper.path)) continue;
			Matcher matcher = wrapper.pattern.matcher(uri);

			// Matches
			Stack<String> matches = new Stack<>();
			while (matcher.find()) {
				if (matcher.groupCount() == 0) break;
				matches.push(matcher.group(1));
			}

			// Execute
			return wrapper.route.process(request, matches.toArray(String[]::new));

		}
		return null;
	}

	@Override
	public void matches(String regex, Route route, Method... methods) {
		for (Method method : methods) {
			int ord = method.ordinal();
			RouteWrapper[] cache = new RouteWrapper[routeWrappers[ord].length + 1];
			System.arraycopy(routeWrappers[ord], 0, cache, 0, routeWrappers[ord].length);
			cache[cache.length - 1] = new RouteWrapper(regex, route);
			routeWrappers[ord] = cache;
		}
	}

}
