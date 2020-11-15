package net.tassia.kiwi.driver.basic;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Status;

import java.io.IOException;
import java.net.Socket;

class DataAcceptor implements Runnable {

	private final BasicDriver driver;
	private final Socket socket;
	private final int clientID;

	DataAcceptor(BasicDriver driver, Socket socket, int clientID) {
		this.driver = driver;
		this.socket = socket;
		this.clientID = clientID;
	}

	@Override
	public void run() {
		try {
			driver.getServer().getLogger().fine("Client #" + clientID + " | Connected from " + socket.getRemoteSocketAddress());
			Response response = null;
			Request request = null;

			// Read request
			try {
				driver.getServer().getLogger().fine("Client #" + clientID + " | Reading request...");
				request = IOUtil.readRequestV1(socket.getInputStream());
			} catch (Throwable ex) {
				ex.printStackTrace();
				response = driver.getServer().getStatusBuilder().buildStatusPage(Status.STATUS_400);
			}

			// Process request
			if (request != null) {
				try {
					driver.getServer().getLogger().fine("Client #" + clientID + " | Processing request...");
					response = driver.getServer().getRouter().route(request);
					if (response == null) response = driver.getServer().getStatusBuilder().buildStatusPage(Status.STATUS_404);
				} catch (Throwable ex) {
					ex.printStackTrace();
					response = driver.getServer().getStatusBuilder().buildStatusPage(Status.STATUS_500);
				}
			} else if (response == null) {
				response = driver.getServer().getStatusBuilder().buildStatusPage(Status.STATUS_500);
			}

			// Write response
			driver.getServer().getLogger().fine("Client #" + clientID + " | Writing response...");
			IOUtil.writeRequestV1(socket.getOutputStream(), response);

			// Close connection
			driver.getServer().getLogger().fine("Client #" + clientID + " | Closing connection...");
			socket.close();

			driver.getServer().getLogger().fine("Client #" + clientID + " | Connection closed.");
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

}
