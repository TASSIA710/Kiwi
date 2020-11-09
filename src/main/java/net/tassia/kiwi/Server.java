package net.tassia.kiwi;

import net.tassia.kiwi.driver.BasicDriver;
import net.tassia.kiwi.driver.Driver;
import net.tassia.kiwi.router.Router;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	private final Logger logger;
	private final Router router;
	private final Driver driver;
	private final ExecutorService services;
	private final ExecutorService clients;

	public Server() {
		// Setup Logger
		this.logger = Logger.getLogger("Kiwi");
		this.logger.setLevel(Level.ALL);

		// Setup misc
		this.router = null;
		this.driver = new BasicDriver(this);

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
