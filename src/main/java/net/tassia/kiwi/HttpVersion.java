package net.tassia.kiwi;

public enum HttpVersion {

	/**
	 * @see <a href="https://tools.ietf.org/html/rfc1945">RFC 1945 - Hypertext Transfer Protocol -- HTTP/1.0</a>
	 */
	HTTP_1_0("HTTP/1.0"),

	/**
	 * @see <a href="https://tools.ietf.org/html/rfc2616">RFC 2616 - Hypertext Transfer Protocol -- HTTP/1.1</a>
	 */
	HTTP_1_1("HTTP/1.1"),

	/**
	 * @see <a href="https://tools.ietf.org/html/rfc7540">RFC 7540 - Hypertext Transfer Protocol Version 2 (HTTP/2)</a>
	 */
	HTTP_2("HTTP/2"),

	/**
	 * @see <a href="https://tools.ietf.org/html/draft-ietf-quic-http-27">Hypertext Transfer Protocol Version 3 (HTTP/3)</a>
	 */
	HTTP_3("HTTP/3");



	private final String name;
	HttpVersion(String name) {
		this.name = name;
	}

	/**
	 * This is the name of this version, used in HTTP requests/responses.
	 * @return the name of this version
	 */
	public String getName() {
		return name;
	}

	/**
	 * Determines the HTTP version using the given name.
	 * @param name the name
	 * @return the parsed version
	 */
	public static HttpVersion parseVersion(String name) {
		switch (name) {
			case "HTTP/1.0": return HTTP_1_0;
			case "HTTP/1.1": return HTTP_1_1;
			case "HTTP/2": return HTTP_2;
			case "HTTP/3": return HTTP_3;
			default: return null;
		}
	}

}
