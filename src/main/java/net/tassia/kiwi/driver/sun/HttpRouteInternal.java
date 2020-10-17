package net.tassia.kiwi.driver.sun;

import net.tassia.kiwi.*;
import net.tassia.kiwi.middleware.Middleware;
import net.tassia.kiwi.route.HttpBasicRoute;
import net.tassia.kiwi.views.HttpView;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRouteInternal {
	protected String path = null;
	protected Pattern pattern = null;
	protected HttpBasicRoute route = null;
	protected Middleware[] middlewares = new Middleware[0];

	protected boolean methodGET = false;
	protected boolean methodPOST = false;
	protected boolean methodPUT = false;
	protected boolean methodDELETE = false;
	protected boolean methodPATCH = false;

	protected boolean run(Kiwi kiwi, HttpRequest request, HttpResponse response) {
		// Check method
		if (request.isMethod(HttpMethod.GET) && !methodGET) return false;
		if (request.isMethod(HttpMethod.POST) && !methodPOST) return false;
		if (request.isMethod(HttpMethod.PUT) && !methodPUT) return false;
		if (request.isMethod(HttpMethod.DELETE) && !methodDELETE) return false;
		if (request.isMethod(HttpMethod.PATCH) && !methodPATCH) return false;


		// Check path
		String uri = request.getPath();
		if (uri.endsWith("/")) uri = uri.substring(0, uri.length() - 1);

		if (!uri.matches(path)) return false;
		Matcher matcher = pattern.matcher(uri);

		Stack<String> matches = new Stack<>();
		while (matcher.find()) {
			if (matcher.groupCount() == 0) break;
			matches.push(matcher.group(1));
		}


		// Execute request middlewares
		for (Middleware mw : middlewares) {
			if (mw.isRequestMiddleware()) {
				if (!mw.applyToRequest(request)) {
					break;
				}
			}
		}


		// Execute route
		try {
			byte[] data = route.process(kiwi, request, response, matches.toArray(new String[0]));
			if (data != null) response.setData(data);
		} catch (Throwable ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.STATUS_500);
		}


		// Execute response middlewares
		for (Middleware mw : middlewares) {
			if (mw.isResponseMiddleware()) {
				if (!mw.applyToResponse(response)) {
					break;
				}
			}
		}
		return true;
	}

}
