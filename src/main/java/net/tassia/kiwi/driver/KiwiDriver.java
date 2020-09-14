package net.tassia.kiwi.driver;

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

	public abstract void GET(String path, HttpRoute route, Middleware...middlewares);

	public abstract void POST(String path, HttpRoute route, Middleware...middlewares);

	public abstract void PUT(String path, HttpRoute route, Middleware...middlewares);

	public abstract void DELETE(String path, HttpRoute route, Middleware...middlewares);

	public abstract void PATCH(String path, HttpRoute route, Middleware...middlewares);

	public abstract void ANY(String path, HttpRoute route, Middleware...middlewares);

	public abstract void MATCHES(String path, HttpRoute route, String[] matches, Middleware...middlewares);

	public abstract void serveStaticAsset(String path, StaticAsset asset);
	/* Abstract Methods */

}
