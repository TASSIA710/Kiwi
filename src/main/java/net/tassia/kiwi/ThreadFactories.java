package net.tassia.kiwi;

import java.util.concurrent.ThreadFactory;

class ThreadFactories {

	private final ThreadGroup servicesGroup = new ThreadGroup("KiwiServices");
	private final ThreadGroup clientsGroup = new ThreadGroup("KiwiClients");

	ThreadFactory servicesFactory = (r) -> new Thread(servicesGroup, r, "Services-" + servicesGroup.activeCount());
	ThreadFactory clientsFactory = (r) -> new Thread(clientsGroup, r, "Clients-" + clientsGroup.activeCount());

}
