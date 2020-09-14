package net.tassia.kiwi;

import java.util.Map;

public interface HasHeaders {

	/**
	 * TODO
	 */
	Map<String, String[]> getHeaders();

	/**
	 * TODO
	 */
	String getHeader(String name);

	/**
	 * TODO
	 */
	String[] getHeaders(String name);

}
