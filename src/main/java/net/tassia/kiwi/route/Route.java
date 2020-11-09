package net.tassia.kiwi.route;

import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;

@FunctionalInterface
public interface Route {
	Response process(Request request);
}
