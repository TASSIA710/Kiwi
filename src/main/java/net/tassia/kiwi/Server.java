package net.tassia.kiwi;

import net.tassia.kiwi.driver.basic.BasicDriver;
import net.tassia.kiwi.driver.Driver;
import net.tassia.kiwi.router.Router;
import net.tassia.kiwi.router.basic.BasicRouter;
import net.tassia.kiwi.statusbuilder.PlainStatusBuilder;
import net.tassia.kiwi.statusbuilder.StatusBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	private final Logger logger;
	private final Router router;
	private final Driver driver;
	private final StatusBuilder statusBuilder;
	private final ExecutorService services;
	private final ExecutorService clients;

	public Server() {
		// Setup Logger
		this.logger = Logger.getLogger("Kiwi");
		this.logger.addHandler(new KiwiLoggingHandler(false));
		this.logger.setUseParentHandlers(false);
		this.logger.setLevel(Level.FINE);

		// Setup misc
		this.router = new BasicRouter();
		this.driver = new BasicDriver(this);
		this.statusBuilder = new PlainStatusBuilder();

		// Setup ExecutorServices
		ThreadFactories threadFactories = new ThreadFactories();
		this.services = Executors.newFixedThreadPool(1, threadFactories.servicesFactory);
		this.clients = Executors.newCachedThreadPool(threadFactories.clientsFactory);
	}

	public Logger getLogger() {
		return logger;
	}

	public Router getRouter() {
		return router;
	}

	public StatusBuilder getStatusBuilder() {
		return statusBuilder;
	}

	public ExecutorService getServiceExecutor() {
		return services;
	}

	public ExecutorService getClientExecutor() {
		return clients;
	}

	public void start() throws IOException {
		driver.start();
	}

	public void stop() throws IOException {
		driver.stop();
	}

}
