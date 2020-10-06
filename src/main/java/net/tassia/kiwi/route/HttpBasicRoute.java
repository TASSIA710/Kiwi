package net.tassia.kiwi.route;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;
import net.tassia.kiwi.Kiwi;

@FunctionalInterface
public interface HttpBasicRoute {

	/**
	 * TODO
	 */
	byte[] process(Kiwi kiwi, HttpRequest request, HttpResponse response, String[] matches);

}
