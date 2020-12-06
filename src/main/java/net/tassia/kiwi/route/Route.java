package net.tassia.kiwi.route;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.Server;

@FunctionalInterface
public interface Route {

	Response process(Server server, Request request, String[] matches);

}
