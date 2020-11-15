package net.tassia.kiwi.enums;

public enum Method {

	/**
	 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	GET,

	/**
	 * The HEAD method asks for a response identical to that of a GET request, but without the response body.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	HEAD,

	/**
	 * The POST method is used to submit an entity to the specified resource, often causing a change in state or side
	 * effects on the server.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	POST,

	/**
	 * The PUT method replaces all current representations of the target resource with the request payload.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	PUT,

	/**
	 * The DELETE method deletes the specified resource.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	DELETE,

	/**
	 * The CONNECT method establishes a tunnel to the server identified by the target resource.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	@Deprecated CONNECT,

	/**
	 * The OPTIONS method is used to describe the communication options for the target resource.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	@Deprecated OPTIONS,

	/**
	 * The TRACE method performs a message loop-back test along the path to the target resource.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	@Deprecated TRACE,

	/**
	 * The PATCH method is used to apply partial modifications to a resource.
	 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods">HTTP Methods</a>
	 */
	PATCH;

	/**
	 * Determines the HTTP method using the given name.
	 * @param name the name
	 * @return the parsed method
	 */
	public static Method parseMethod(String name) {
		switch (name) {
			case "GET": return GET;
			case "HEAD": return HEAD;
			case "POST": return POST;
			case "PUT": return PUT;
			case "DELETE": return DELETE;
			case "CONNECT": return CONNECT;
			case "OPTIONS": return OPTIONS;
			case "TRACE": return TRACE;
			case "PATCH": return PATCH;
			default: return null;
		}
	}

}
