package net.tassia.kiwi.driver;

import net.tassia.kiwi.Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicDriver extends Driver {

	private ServerSocket serverSocket;

	public BasicDriver(Server server) {
		super("Kiwi", "1.0.0", server);
	}

	@Override
	public void start() throws IOException {
		serverSocket = new ServerSocket(8080);
		getServer().getServiceExecutor().submit(new SocketAcceptor());
	}

	@Override
	public void stop() throws IOException {
		serverSocket.close();
	}



	private class SocketAcceptor implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					Socket socket = serverSocket.accept();
					getServer().getClientExecutor().submit(new DataAcceptor(socket));
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class DataAcceptor implements Runnable {
		private final Socket socket;
		private DataAcceptor(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				getServer().getLogger().info("Incoming connection from " + socket.getRemoteSocketAddress());
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
