package net.tassia.kiwi.enums;

public enum StatusCategory {

	/**
	 * An informational response indicates that the request was received and understood. It is issued on a provisional
	 * basis while request processing continues. It alerts the client to wait for a final response. The message consists
	 * only of the status line and optional header fields, and is terminated by an empty line. As the HTTP/1.0 standard
	 * did not define any 1xx status codes, servers must not send a 1xx response to an HTTP/1.0 compliant client except
	 * under experimental conditions.
	 */
	INFORMATIONAL,

	/**
	 * This class of status codes indicates the action requested by the client was received, understood, and accepted.
	 */
	SUCCESS,

	/**
	 * This class of status code indicates the client must take additional action to complete the request. Many of
	 * these status codes are used in URL redirection.
	 *
	 * A user agent may carry out the additional action with no user interaction only if the method used in the second
	 * request is GET or HEAD. A user agent may automatically redirect a request. A user agent should detect and
	 * intervene to prevent cyclical redirects.
	 */
	REDIRECTION,

	/**
	 * This class of status code is intended for situations in which the error seems to have been caused by the client.
	 * Except when responding to a HEAD request, the server should include an entity containing an explanation of the
	 * error situation, and whether it is a temporary or permanent condition. These status codes are applicable to any
	 * request method. User agents should display any included entity to the user.
	 */
	CLIENT_ERROR,

	/**
	 * The server failed to fulfill a request. Response status codes beginning with the digit "5" indicate cases in
	 * which the server is aware that it has encountered an error or is otherwise incapable of performing the request.
	 * Except when responding to a HEAD request, the server should include an entity containing an explanation of the
	 * error situation, and indicate whether it is a temporary or permanent condition. Likewise, user agents should
	 * display any included entity to the user. These response codes are applicable to any request method.
	 */
	SERVER_ERROR

}
