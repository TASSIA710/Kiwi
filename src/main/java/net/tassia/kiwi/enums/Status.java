package net.tassia.kiwi.enums;

public enum Status {

	/**
	 * The initial part of a request has been received and has not yet been rejected by the server. The server intends
	 * to send a final response after the request has been fully received and acted upon.
	 * @see <a href="https://httpstatuses.com/100">100 Continue</a>
	 */
	STATUS_100(100, "Continue", StatusCategory.INFORMATIONAL),

	/**
	 * The server understands and is willing to comply with the client's request, via the Upgrade header field, for a
	 * change in the application protocol being used on this connection.
	 * @see <a href="https://httpstatuses.com/101">101 Switching Protocols</a>
	 */
	STATUS_101(101, "Switching Protocols", StatusCategory.INFORMATIONAL),

	/**
	 * An interim response used to inform the client that the server has accepted the complete request,
	 * but has not yet completed it.
	 * @see <a href="https://httpstatuses.com/102">102 Processing</a>
	 */
	STATUS_102(102, "Processing", StatusCategory.INFORMATIONAL),

	/**
	 * The request has succeeded.
	 * @see <a href="https://httpstatuses.com/200">200 OK</a>
	 */
	STATUS_200(200, "OK", StatusCategory.SUCCESS),

	/**
	 * The request has been fulfilled and has resulted in one or more new resources being created.
	 * @see <a href="https://httpstatuses.com/201">201 Created</a>
	 */
	STATUS_201(201, "Created", StatusCategory.SUCCESS),

	/**
	 * The request has been accepted for processing, but the processing has not been completed. The request might or
	 * might not eventually be acted upon, as it might be disallowed when processing actually takes place.
	 * @see <a href="https://httpstatuses.com/202">202 Accepted</a>
	 */
	STATUS_202(202, "Accepted", StatusCategory.SUCCESS),

	/**
	 * The request was successful but the enclosed payload has been modified from that of the origin server's 200 OK
	 * response by a transforming proxy.
	 * @see <a href="https://httpstatuses.com/203">203 Non-authoritative Information</a>
	 */
	STATUS_203(203, "Non-authoritative Information", StatusCategory.SUCCESS),

	/**
	 * The server has successfully fulfilled the request and that there is no additional content to send in the
	 * response payload body.
	 * @see <a href="https://httpstatuses.com/204">204 No Content</a>
	 */
	STATUS_204(204, "No Content", StatusCategory.SUCCESS),

	/**
	 * The server has fulfilled the request and desires that the user agent reset the "document view", which caused
	 * the request to be sent, to its original state as received from the origin server.
	 * @see <a href="https://httpstatuses.com/205">205 Reset Content</a>
	 */
	STATUS_205(205, "Reset Content", StatusCategory.SUCCESS),

	/**
	 * The server is successfully fulfilling a range request for the target resource by transferring one or more
	 * parts of the selected representation that correspond to the satisfiable ranges found in the request's
	 * Range header field.
	 * @see <a href="https://httpstatuses.com/206">206 Partial Content</a>
	 */
	STATUS_206(206, "Partial Content", StatusCategory.SUCCESS),

	/**
	 * A Multi-Status response conveys information about multiple resources in situations where multiple status codes
	 * might be appropriate.
	 * @see <a href="https://httpstatuses.com/207">207 Multi-Status</a>
	 */
	STATUS_207(207, "Multi-Status", StatusCategory.SUCCESS),

	/**
	 * Used inside a DAV: propstat response element to avoid enumerating the internal members of multiple bindings
	 * to the same collection repeatedly.
	 * @see <a href="https://httpstatuses.com/208">208 Already Reported</a>
	 */
	STATUS_208(208, "Already Reported", StatusCategory.SUCCESS),

	/**
	 * The server has fulfilled a GET request for the resource, and the response is a representation of the result of
	 * one or more instance-manipulations applied to the current instance.
	 * @see <a href="https://httpstatuses.com/226">226 IM Used</a>
	 */
	STATUS_226(226, "IM Used", StatusCategory.SUCCESS),

	/**
	 * The target resource has more than one representation, each with its own more specific identifier, and
	 * information about the alternatives is being provided so that the user (or user agent) can select a
	 * preferred representation by redirecting its request to one or more of those identifiers.
	 * @see <a href="https://httpstatuses.com/300">300 Multiple Choices</a>
	 */
	STATUS_300(300, "Multiple Choices", StatusCategory.REDIRECTION),

	/**
	 * The target resource has been assigned a new permanent URI and any future references to this resource ought to
	 * use one of the enclosed URIs.
	 * @see <a href="https://httpstatuses.com/301">301 Moved Permanently</a>
	 */
	STATUS_301(301, "Moved Permanently", StatusCategory.REDIRECTION),

	/**
	 * The target resource resides temporarily under a different URI. Since the redirection might be altered on
	 * occasion, the client ought to continue to use the effective request URI for future requests.
	 * @see <a href="https://httpstatuses.com/302">302 Found</a>
	 */
	STATUS_302(302, "Found", StatusCategory.REDIRECTION),

	/**
	 * The server is redirecting the user agent to a different resource, as indicated by a URI in the Location header
	 * field, which is intended to provide an indirect response to the original request.
	 * @see <a href="https://httpstatuses.com/303">303 See Other</a>
	 */
	STATUS_303(303, "See Other", StatusCategory.REDIRECTION),

	/**
	 * A conditional GET or HEAD request has been received and would have resulted in a {@link #STATUS_200} response
	 * if it were not for the fact that the condition evaluated to false.
	 * @see <a href="https://httpstatuses.com/304">304 Not Modified</a>
	 */
	STATUS_304(304, "Not Modified", StatusCategory.REDIRECTION),

	/**
	 * Defined in a previous version of this specification and is now deprecated, due to security concerns regarding
	 * in-band configuration of a proxy.
	 * @see <a href="https://httpstatuses.com/305">305 Use Proxy</a>
	 */
	STATUS_305(305, "Use Proxy", StatusCategory.REDIRECTION),

	/**
	 * The target resource resides temporarily under a different URI and the user agent MUST NOT change the request
	 * method if it performs an automatic redirection to that URI.
	 * @see <a href="https://httpstatuses.com/307">307 Temporary Redirect</a>
	 */
	STATUS_307(307, "Temporary Redirect", StatusCategory.REDIRECTION),

	/**
	 * The target resource has been assigned a new permanent URI and any future references to this resource ought
	 * to use one of the enclosed URIs.
	 * @see <a href="https://httpstatuses.com/308">308 Permanent Redirect</a>
	 */
	STATUS_308(308, "Permanent Redirect", StatusCategory.REDIRECTION),

	/**
	 * The server cannot or will not process the request due to something that is perceived to be a client error
	 * (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).
	 * @see <a href="https://httpstatuses.com/400">400 Bad Request</a>
	 */
	STATUS_400(400, "Bad Request", StatusCategory.CLIENT_ERROR),

	/**
	 * The request has not been applied because it lacks valid authentication credentials for the target resource.
	 * @see <a href="https://httpstatuses.com/401">401 Unauthorized</a>
	 */
	STATUS_401(401, "Unauthorized", StatusCategory.CLIENT_ERROR),

	/**
	 * Reserved for future use.
	 * @see <a href="https://httpstatuses.com/402">402 Payment Required</a>
	 */
	STATUS_402(402, "Payment Required", StatusCategory.CLIENT_ERROR),

	/**
	 * The server understood the request but refuses to authorize it.
	 * @see <a href="https://httpstatuses.com/403">403 Forbidden</a>
	 */
	STATUS_403(403, "Forbidden", StatusCategory.CLIENT_ERROR),

	/**
	 * The origin server did not find a current representation for the target resource or is not willing to disclose
	 * that one exists.
	 * @see <a href="https://httpstatuses.com/404">404 Not Found</a>
	 */
	STATUS_404(404, "Not Found", StatusCategory.CLIENT_ERROR),

	/**
	 * The method received in the request-line is known by the origin server but not supported by the target resource.
	 * @see <a href="https://httpstatuses.com/405">405 Method Not Allowed</a>
	 */
	STATUS_405(405, "Method Not Allowed", StatusCategory.CLIENT_ERROR),

	/**
	 * The target resource does not have a current representation that would be acceptable to the user agent,
	 * according to the proactive negotiation header fields received in the request, and the server is
	 * unwilling to supply a default representation.
	 * @see <a href="https://httpstatuses.com/406">406 Not Acceptable</a>
	 */
	STATUS_406(406, "Not Acceptable", StatusCategory.CLIENT_ERROR),

	/**
	 * Similar to {@link #STATUS_401}, but it indicates that the client needs to authenticate itself in order to use a proxy.
	 * @see <a href="https://httpstatuses.com/407">407 Proxy Authentication Required</a>
	 */
	STATUS_407(407, "Proxy Authentication Required", StatusCategory.CLIENT_ERROR),

	/**
	 * The server did not receive a complete request message within the time that it was prepared to wait.
	 * @see <a href="https://httpstatuses.com/408">408 Request Timeout</a>
	 */
	STATUS_408(408, "Request Timeout", StatusCategory.CLIENT_ERROR),

	/**
	 * The request could not be completed due to a conflict with the current state of the target resource. This code is
	 * used in situations where the user might be able to resolve the conflict and resubmit the request.
	 * @see <a href="https://httpstatuses.com/409">409 Conflict</a>
	 */
	STATUS_409(409, "Conflict", StatusCategory.CLIENT_ERROR),

	/**
	 * The target resource is no longer available at the origin server and that this condition is likely to be permanent.
	 * @see <a href="https://httpstatuses.com/410">410 Gone</a>
	 */
	STATUS_410(410, "Gone", StatusCategory.CLIENT_ERROR),

	/**
	 * The server refuses to accept the request without a defined Content-Length.
	 * @see <a href="https://httpstatuses.com/411">411 Length Required</a>
	 */
	STATUS_411(411, "Length Required", StatusCategory.CLIENT_ERROR),

	/**
	 * One or more conditions given in the request header fields evaluated to false when tested on the server.
	 * @see <a href="https://httpstatuses.com/412">412 Precondition Failed</a>
	 */
	STATUS_412(412, "Precondition Failed", StatusCategory.CLIENT_ERROR),

	/**
	 * The server is refusing to process a request because the request payload is larger than the server is willing
	 * or able to process.
	 * @see <a href="https://httpstatuses.com/413">413 Payload Too Large</a>
	 */
	STATUS_413(413, "Payload Too Large", StatusCategory.CLIENT_ERROR),

	/**
	 * The server is refusing to service the request because the request-target is longer than the server is willing
	 * to interpret.
	 * @see <a href="https://httpstatuses.com/414">414 Request-URI Too Long</a>
	 */
	STATUS_414(414, "Request-URI Too Long", StatusCategory.CLIENT_ERROR),

	/**
	 * The origin server is refusing to service the request because the payload is in a format not supported by this
	 * method on the target resource.
	 * @see <a href="https://httpstatuses.com/415">415 Unsupported Media Type</a>
	 */
	STATUS_415(415, "Unsupported Media Type", StatusCategory.CLIENT_ERROR),

	/**
	 * None of the ranges in the request's Range header field overlap the current extent of the selected resource or
	 * that the set of ranges requested has been rejected due to invalid ranges or an excessive request of small or
	 * overlapping ranges.
	 * @see <a href="https://httpstatuses.com/416">416 Requested Range Not Satisfiable</a>
	 */
	STATUS_416(416, "Requested Range Not Satisfiable", StatusCategory.CLIENT_ERROR),

	/**
	 * The expectation given in the request's Expect header field could not be met by at least one of the inbound servers.
	 * @see <a href="https://httpstatuses.com/417">417 Expectation Failed</a>
	 */
	STATUS_417(417, "Expectation Failed", StatusCategory.CLIENT_ERROR),

	/**
	 * Any attempt to brew coffee with a teapot should result in the error code "418 I'm a teapot".
	 * The resulting entity body MAY be short and stout.
	 * @see <a href="https://httpstatuses.com/418">418 I'm a teapot</a>
	 */
	STATUS_418(418, "I'm a teapot", StatusCategory.CLIENT_ERROR),

	/**
	 * The request was directed at a server that is not able to produce a response. This can be sent by a server that
	 * is not configured to produce responses for the combination of scheme and authority that are included in the
	 * request URI.
	 * @see <a href="https://httpstatuses.com/421">421 Misdirected Request</a>
	 */
	STATUS_421(421, "Misdirected Request", StatusCategory.CLIENT_ERROR),

	/**
	 * The server understands the content type of the request entity (hence a {@link #STATUS_415} status code is
	 * inappropriate), and the syntax of the request entity is correct (thus a {@link #STATUS_400} status code is
	 * inappropriate) but was unable to process the contained instructions.
	 * @see <a href="https://httpstatuses.com/422">422 Unprocessable Entity</a>
	 */
	STATUS_422(422, "Unprocessable Entity", StatusCategory.CLIENT_ERROR),

	/**
	 * The source or destination resource of a method is locked.
	 * @see <a href="https://httpstatuses.com/423">423 Locked</a>
	 */
	STATUS_423(423, "Locked", StatusCategory.CLIENT_ERROR),

	/**
	 * The method could not be performed on the resource because the requested action depended on another action
	 * and that action failed.
	 * @see <a href="https://httpstatuses.com/424">424 Failed Dependency</a>
	 */
	STATUS_424(424, "Failed Dependency", StatusCategory.CLIENT_ERROR),

	/**
	 * The server refuses to perform the request using the current protocol but might be willing to do so after the
	 * client upgrades to a different protocol.
	 * @see <a href="https://httpstatuses.com/426">426 Upgrade Required</a>
	 */
	STATUS_426(426, "Upgrade Required", StatusCategory.CLIENT_ERROR),

	/**
	 * The origin server requires the request to be conditional.
	 * @see <a href="https://httpstatuses.com/428">428 Precondition Failed</a>
	 */
	STATUS_428(428, "Precondition Failed", StatusCategory.CLIENT_ERROR),

	/**
	 * The user has sent too many requests in a given amount of time ("rate limiting").
	 * @see <a href="https://httpstatuses.com/429">429 Too Many Requests</a>
	 */
	STATUS_429(429, "Too Many Requests", StatusCategory.CLIENT_ERROR),

	/**
	 * The server is unwilling to process the request because its header fields are too large. The request MAY be
	 * resubmitted after reducing the size of the request header fields.
	 * @see <a href="https://httpstatuses.com/431">431 Request Header Fields Too Large</a>
	 */
	STATUS_431(431, "Request Header Fields Too Large", StatusCategory.CLIENT_ERROR),

	/**
	 * A non-standard status code used to instruct nginx to close the connection without sending a response to the
	 * client, most commonly used to deny malicious or malformed requests.
	 * @see <a href="https://httpstatuses.com/444">444 Connection Closed Without Response</a>
	 */
	STATUS_444(444, "Connection Closed Without Response", StatusCategory.CLIENT_ERROR),

	/**
	 * The server is denying access to the resource as a consequence of a legal demand.
	 * @see <a href="https://httpstatuses.com/451">451 Unavailable For Legal Reasons</a>
	 */
	STATUS_451(451, "Unavailable For Legal Reasons", StatusCategory.CLIENT_ERROR),

	/**
	 * A non-standard status code introduced by nginx for the case when a client closes the connection
	 * while nginx is processing the request.
	 * @see <a href="https://httpstatuses.com/499">499 Client Closed Request</a>
	 */
	STATUS_499(499, "Client Closed Request", StatusCategory.CLIENT_ERROR),

	/**
	 * The server encountered an unexpected condition that prevented it from fulfilling the request.
	 * @see <a href="https://httpstatuses.com/500">500 Internal Server Error</a>
	 */
	STATUS_500(500, "Internal Server Error", StatusCategory.SERVER_ERROR),

	/**
	 * The server does not support the functionality required to fulfill the request.
	 * @see <a href="https://httpstatuses.com/501">501 Not Implemented</a>
	 */
	STATUS_501(501, "Not Implemented", StatusCategory.SERVER_ERROR),

	/**
	 * The server, while acting as a gateway or proxy, received an invalid response from an inbound server it
	 * accessed while attempting to fulfill the request.
	 * @see <a href="https://httpstatuses.com/502">502 Bad Gateway</a>
	 */
	STATUS_502(502, "Bad Gateway", StatusCategory.SERVER_ERROR),

	/**
	 * The server is currently unable to handle the request due to a temporary overload or scheduled maintenance,
	 * which will likely be alleviated after some delay.
	 * @see <a href="https://httpstatuses.com/503">503 Service Unavailable</a>
	 */
	STATUS_503(503, "Service Unavailable", StatusCategory.SERVER_ERROR),

	/**
	 * The server, while acting as a gateway or proxy, did not receive a timely response from an upstream server it
	 * needed to access in order to complete the request.
	 * @see <a href="https://httpstatuses.com/504">504 Gateway Timeout</a>
	 */
	STATUS_504(504, "Gateway Timeout", StatusCategory.SERVER_ERROR),

	/**
	 * The server does not support, or refuses to support, the major version of HTTP that was used in the
	 * request message.
	 * @see <a href="https://httpstatuses.com/505">505 HTTP Version Not Supported</a>
	 */
	STATUS_505(505, "HTTP Version Not Supported", StatusCategory.SERVER_ERROR),

	/**
	 * The server has an internal configuration error: the chosen variant resource is configured to engage in
	 * transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.
	 * @see <a href="https://httpstatuses.com/506">506 Variant Also Negotiates</a>
	 */
	STATUS_506(506, "Variant Also Negotiates", StatusCategory.SERVER_ERROR),

	/**
	 * The method could not be performed on the resource because the server is unable to store the representation
	 * needed to successfully complete the request.
	 * @see <a href="https://httpstatuses.com/507">507 Insufficient Storage</a>
	 */
	STATUS_507(507, "Insufficient Storage", StatusCategory.SERVER_ERROR),

	/**
	 * The server terminated an operation because it encountered an infinite loop while processing a request with
	 * "Depth: infinity". This status indicates that the entire operation failed.
	 * @see <a href="https://httpstatuses.com/508">508 Loop Detected</a>
	 */
	STATUS_508(508, "Loop Detected", StatusCategory.SERVER_ERROR),

	/**
	 * The policy for accessing the resource has not been met in the request. The server should send back all the
	 * information necessary for the client to issue an extended request.
	 * @see <a href="https://httpstatuses.com/510">510 Not Extended</a>
	 */
	STATUS_510(510, "Not Extended", StatusCategory.SERVER_ERROR),

	/**
	 * The client needs to authenticate to gain network access.
	 * @see <a href="https://httpstatuses.com/511">511 Network Authentication Required</a>
	 */
	STATUS_511(511, "Network Authentication Required", StatusCategory.SERVER_ERROR),

	/**
	 * This status code is not specified in any RFCs, but is used by some HTTP proxies to signal a network connect
	 * timeout behind the proxy to a client in front of the proxy.
	 * @see <a href="https://httpstatuses.com/599">599 Network Connect Timeout Error</a>
	 */
	STATUS_599(599, "Network Connect Timeout Error", StatusCategory.SERVER_ERROR);





	private final int code;
	private final String status;
	private final StatusCategory category;
	Status(int code, String status, StatusCategory category) {
		this.code = code;
		this.status = status;
		this.category = category;
	}

	/**
	 * Returns the code (e.g. 404) of this status.
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Returns the status text (e.g. 'Not Found') of this status.
	 * @return the status text
	 */
	public String getStatusText() {
		return status;
	}

	/**
	 * Returns the category of this status.
	 * @return the category
	 * @see StatusCategory
	 */
	public StatusCategory getCategory() {
		return category;
	}

	/**
	 * Determines the HTTP status using the given code.
	 * @param code the code
	 * @return the parsed status
	 */
	public static Status parseVersion(int code) {
		for (Status st : values()) {
			if (st.code == code) return st;
		}
		return null;
	}

	/**
	 * Determines the HTTP status using the given status line.
	 * @param status the status line
	 * @return the parsed status
	 */
	public static Status parseVersion(String status) {
		for (Status st : values()) {
			if (st.status.equals(status)) return st;
		}
		return null;
	}

}
