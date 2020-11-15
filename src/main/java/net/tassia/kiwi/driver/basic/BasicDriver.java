package net.tassia.kiwi.driver.basic;

import net.tassia.kiwi.Server;
import net.tassia.kiwi.driver.Driver;

import java.io.*;
import java.net.ServerSocket;

public class BasicDriver extends Driver {

	protected ServerSocket serverSocket;

	public BasicDriver(Server server) {
		super("Kiwi", "1.0.0", server);
	}

	@Override
	public void start() throws IOException {
		serverSocket = new ServerSocket(8080);
		getServer().getServiceExecutor().submit(new SocketAcceptor(this));
	}

	@Override
	public void stop() throws IOException {
		serverSocket.close();
	}

}
