package net.tassia.kiwi.driver.basic;

import java.io.IOException;
import java.net.Socket;

class SocketAcceptor implements Runnable {

	private final BasicDriver driver;
	private int clientCounter;

	SocketAcceptor(BasicDriver driver) {
		this.driver = driver;
		this.clientCounter = 1;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = driver.serverSocket.accept();
				driver.getServer().getClientExecutor().submit(new DataAcceptor(driver, socket, clientCounter++));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
