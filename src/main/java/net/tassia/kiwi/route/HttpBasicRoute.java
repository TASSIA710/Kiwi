package net.tassia.kiwi.route;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;
import net.tassia.kiwi.Kiwi;

/**
 * This is the basic route. This is as simple as it can get, no data parsing or manipulating is happening here.
 * The {@link #process(Kiwi, HttpRequest, HttpResponse, String[])} function is directly called from the driver.
 */
@FunctionalInterface
public interface HttpBasicRoute {

	/**
	 * Processes this HTTP request.
	 * @param kiwi main
	 * @param request the request
	 * @param response the response
	 * @param matches the matches if the route regex specified any groups
	 * @return the data to send back or <code>null</code> if data was set via {@link HttpResponse#setData(byte[])}
	 */
	byte[] process(Kiwi kiwi, HttpRequest request, HttpResponse response, String[] matches);

}
