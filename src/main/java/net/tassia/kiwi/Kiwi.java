package net.tassia.kiwi;

import net.tassia.kiwi.driver.KiwiDriver;
import net.tassia.kiwi.middleware.Middleware;
import net.tassia.kiwi.route.HttpRoute;

import java.util.logging.Logger;

public class Kiwi {
	public static final int VERSION_MAJOR = 0;
	public static final int VERSION_MINOR = 0;
	public static final int VERSION_PATCH = 1;
	public static final int VERSION_BUILD = 1;
	private final Logger logger;
	private KiwiDriver driver;
	private KiwiOptions options;

	/* Constructor */
	/**
	 * TODO
	 */
	public Kiwi() {
		this(new KiwiOptions());
	}

	/**
	 * TODO
	 */
	public Kiwi(KiwiOptions options) {
		this.logger = Logger.getLogger("Kiwi");
		this.driver = null;
		this.options = options;
	}
	/* Constructor */





	/* Driver */
	public void setDriver(KiwiDriver driver) {
		this.driver = driver;
	}

	public KiwiDriver getDriver() {
		return driver;
	}
	/* Driver */





	/* Server Name */
	/**
	 * TODO
	 */
	public String getServerName() {
		return "Kiwi/" + driver.getName() + " - " + VERSION_MAJOR + "." + VERSION_MINOR;
	}
	/* Server Name */





	/* Options */
	/**
	 * TODO
	 */
	public KiwiOptions getOptions() {
		return options;
	}

	/**
	 * TODO
	 */
	public void setOptions(KiwiOptions options) {
		this.options = options;
	}
	/* Options */





	/* Getters */
	public Logger getLogger() {
		return logger;
	}
	/* Getters */





	/* Driver Wrapper */
	/**
	 * TODO
	 */
	public void start() {
		logger.info("Starting HTTP server...");
		driver.start();
		logger.info("Started HTTP server, listening on port " + options.port + ".");
	}

	/**
	 * TODO
	 */
	public void stop() {
		logger.info("Stopping HTTP server...");
		driver.stop();
		logger.info("Stopped HTTP server.");
	}

	/**
	 * TODO
	 */
	public boolean isRunning() {
		return driver.isRunning();
	}

	/**
	 * TODO
	 */
	public void MATCHES(String path, HttpRoute route, HttpMethod[] matches, Middleware...middlewares) {
		driver.MATCHES(path, route, matches, middlewares);
	}

	/**
	 * TODO
	 */
	public void serveStaticAsset(String path, StaticAsset asset) {
		driver.serveStaticAsset(path, asset);
	}

	/**
	 * TODO
	 */
	public void GET(String path, HttpRoute route, Middleware...middlewares) {
		driver.GET(path, route, middlewares);
	}

	/**
	 * TODO
	 */
	public void POST(String path, HttpRoute route, Middleware...middlewares) {
		driver.POST(path, route, middlewares);
	}

	/**
	 * TODO
	 */
	public void PUT(String path, HttpRoute route, Middleware...middlewares) {
		driver.PUT(path, route, middlewares);
	}

	/**
	 * TODO
	 */
	public void DELETE(String path, HttpRoute route, Middleware...middlewares) {
		driver.DELETE(path, route, middlewares);
	}

	/**
	 * TODO
	 */
	public void PATCH(String path, HttpRoute route, Middleware...middlewares) {
		driver.PATCH(path, route, middlewares);
	}

	/**
	 * TODO
	 */
	public void ANY(String path, HttpRoute route, Middleware...middlewares) {
		driver.ANY(path, route, middlewares);
	}
	/* Driver Wrapper */

}
