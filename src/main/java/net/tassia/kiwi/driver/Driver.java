package net.tassia.kiwi.driver;

import net.tassia.kiwi.Server;

import java.io.IOException;

public abstract class Driver {

	private final String name, version;
	private final Server server;

	public Driver(String name, String version, Server server) {
		this.name = name;
		this.version = version;
		this.server = server;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public Server getServer() {
		return server;
	}

	public abstract void start() throws IOException;
	public abstract void stop() throws IOException;

}
