package net.tassia.kiwi.driver;

import net.tassia.kiwi.HttpMethod;
import net.tassia.kiwi.StaticAsset;
import net.tassia.kiwi.middleware.Middleware;
import net.tassia.kiwi.route.HttpRoute;

public abstract class KiwiDriver {
	private final String name;

	/* Constructor */
	public KiwiDriver(String name) {
		this.name = name;
	}
	/* Constructor */





	/* Getters */
	public String getName() {
		return name;
	}
	/* Getters */





	/* Abstract Methods */
	public abstract void start();

	public abstract void stop();

	public abstract boolean isRunning();

	public abstract void MATCHES(String path, HttpRoute route, HttpMethod[] matches, Middleware...middlewares);

	public abstract void serveStaticAsset(String path, StaticAsset asset);
	/* Abstract Methods */





	/* Routes */
	public void GET(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, new HttpMethod[] { HttpMethod.GET }, middlewares);
	}

	public void POST(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, new HttpMethod[] { HttpMethod.POST }, middlewares);
	}

	public void PUT(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, new HttpMethod[] { HttpMethod.PUT }, middlewares);
	}

	public void DELETE(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, new HttpMethod[] { HttpMethod.DELETE }, middlewares);
	}

	public void PATCH(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, new HttpMethod[] { HttpMethod.PATCH }, middlewares);
	}

	public void ANY(String path, HttpRoute route, Middleware...middlewares) {
		MATCHES(path, route, HttpMethod.values(), middlewares);
	}
	/* Routes */

}
