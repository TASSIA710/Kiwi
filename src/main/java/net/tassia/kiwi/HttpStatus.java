package net.tassia.kiwi;

import net.tassia.kiwi.views.HttpView;

import java.nio.charset.StandardCharsets;

public enum HttpStatus {

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/100">100 Continue</a>
	 */
	STATUS_100(100, "Continue", HttpStatusCategory.INFORMATIONAL),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/101">101 Switching Protocols</a>
	 */
	STATUS_101(101, "Switching Protocols", HttpStatusCategory.INFORMATIONAL),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/102">102 Processing</a>
	 */
	STATUS_102(102, "Processing", HttpStatusCategory.INFORMATIONAL),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/200">200 OK</a>
	 */
	STATUS_200(200, "OK", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/201">201 Created</a>
	 */
	STATUS_201(201, "Created", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/202">202 Accepted</a>
	 */
	STATUS_202(202, "Accepted", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/203">203 Non-authoritative Information</a>
	 */
	STATUS_203(203, "Non-authoritative Information", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/204">204 No Content</a>
	 */
	STATUS_204(204, "No Content", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/205">205 Reset Content</a>
	 */
	STATUS_205(205, "Reset Content", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/206">206 Partial Content</a>
	 */
	STATUS_206(206, "Partial Content", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/207">207 Multi-Status</a>
	 */
	STATUS_207(207, "Multi-Status", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/208">208 Already Reported</a>
	 */
	STATUS_208(208, "Already Reported", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/226">226 IM Used</a>
	 */
	STATUS_226(226, "IM Used", HttpStatusCategory.SUCCESS),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/300">300 Multiple Choices</a>
	 */
	STATUS_300(300, "Multiple Choices", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/301">301 Moved Permanently</a>
	 */
	STATUS_301(301, "Moved Permanently", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/302">302 Found</a>
	 */
	STATUS_302(302, "Found", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/303">303 See Other</a>
	 */
	STATUS_303(303, "See Other", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/304">304 Not Modified</a>
	 */
	STATUS_304(304, "Not Modified", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/305">305 Use Proxy</a>
	 */
	STATUS_305(305, "Use Proxy", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/307">307 Temporary Redirect</a>
	 */
	STATUS_307(307, "Temporary Redirect", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/308">308 Permanent Redirect</a>
	 */
	STATUS_308(308, "Permanent Redirect", HttpStatusCategory.REDIRECTION),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/400">400 Bad Request</a>
	 */
	STATUS_400(400, "Bad Request", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/401">401 Unauthorized</a>
	 */
	STATUS_401(401, "Unauthorized", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/402">402 Payment Required</a>
	 */
	STATUS_402(402, "Payment Required", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/403">403 Forbidden</a>
	 */
	STATUS_403(403, "Forbidden", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/404">404 Not Found</a>
	 */
	STATUS_404(404, "Not Found", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/405">405 Method Not Allowed</a>
	 */
	STATUS_405(405, "Method Not Allowed", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/406">406 Not Acceptable</a>
	 */
	STATUS_406(406, "Not Acceptable", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/407">407 Proxy Authentication Required</a>
	 */
	STATUS_407(407, "Proxy Authentication Required", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/408">408 Request Timeout</a>
	 */
	STATUS_408(408, "Request Timeout", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/409">409 Conflict</a>
	 */
	STATUS_409(409, "Conflict", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/410">410 Gone</a>
	 */
	STATUS_410(410, "Gone", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/411">411 Length Required</a>
	 */
	STATUS_411(411, "Length Required", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/412">412 Precondition Failed</a>
	 */
	STATUS_412(412, "Precondition Failed", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/413">413 Payload Too Large</a>
	 */
	STATUS_413(413, "Payload Too Large", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/414">414 Request-URI Too Long</a>
	 */
	STATUS_414(414, "Request-URI Too Long", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/415">415 Unsupported Media Type</a>
	 */
	STATUS_415(415, "Unsupported Media Type", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/416">416 Requested Range Not Satisfiable</a>
	 */
	STATUS_416(416, "Requested Range Not Satisfiable", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/417">417 Expectation Failed</a>
	 */
	STATUS_417(417, "Expectation Failed", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/418">418 I'm a teapot</a>
	 */
	STATUS_418(418, "I'm a teapot", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/421">421 Misdirected Request</a>
	 */
	STATUS_421(421, "Misdirected Request", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/422">422 Unprocessable Entity</a>
	 */
	STATUS_422(422, "Unprocessable Entity", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/423">423 Locked</a>
	 */
	STATUS_423(423, "Locked", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/424">424 Failed Dependency</a>
	 */
	STATUS_424(424, "Failed Dependency", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/426">426 Upgrade Required</a>
	 */
	STATUS_426(426, "Upgrade Required", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/428">428 Precondition Failed</a>
	 */
	STATUS_428(428, "Precondition Failed", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/429">429 Too Many Requests</a>
	 */
	STATUS_429(429, "Too Many Requests", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/431">431 Request Header Fields Too Large</a>
	 */
	STATUS_431(431, "Request Header Fields Too Large", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/444">444 Connection Closed Without Response</a>
	 */
	STATUS_444(444, "Connection Closed Without Response", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/451">451 Unavailable For Legal Reasons</a>
	 */
	STATUS_451(451, "Unavailable For Legal Reasons", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/499">499 Client Closed Request</a>
	 */
	STATUS_499(499, "Client Closed Request", HttpStatusCategory.CLIENT_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/500">500 Internal Server Error</a>
	 */
	STATUS_500(500, "Internal Server Error", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/501">501 Not Implemented</a>
	 */
	STATUS_501(501, "Not Implemented", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/502">502 Bad Gateway</a>
	 */
	STATUS_502(502, "Bad Gateway", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/503">503 Service Unavailable</a>
	 */
	STATUS_503(503, "Service Unavailable", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/504">504 Gateway Timeout</a>
	 */
	STATUS_504(504, "Gateway Timeout", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/505">505 HTTP Version Not Supported</a>
	 */
	STATUS_505(505, "HTTP Version Not Supported", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/506">506 Variant Also Negotiates</a>
	 */
	STATUS_506(506, "Variant Also Negotiates", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/507">507 Insufficient Storage</a>
	 */
	STATUS_507(507, "Insufficient Storage", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/508">508 Loop Detected</a>
	 */
	STATUS_508(508, "Loop Detected", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/510">510 Not Extended</a>
	 */
	STATUS_510(510, "Not Extended", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/511">511 Network Authentication Required</a>
	 */
	STATUS_511(511, "Network Authentication Required", HttpStatusCategory.SERVER_ERROR),

	/**
	 * TODO
	 * @see <a href="https://httpstatuses.com/599">599 Network Connect Timeout Error</a>
	 */
	STATUS_599(599, "Network Connect Timeout Error", HttpStatusCategory.SERVER_ERROR);





	private final int code;
	private final String status;
	private final HttpStatusCategory category;
	private final HttpView view;
	HttpStatus(int code, String status, HttpStatusCategory category) {
		this.code = code;
		this.status = status;
		this.category = category;
		this.view = HttpView.createStatic("text/plain", "utf8", status.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Returns the code (e.g. 404) of this status.
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Returns the status line (e.g. 'Not Found') of this status.
	 * @return the status line
	 */
	public String getStatusLine() {
		return status;
	}

	/**
	 * Returns the category of this status.
	 * @return the category
	 * @see HttpStatusCategory
	 */
	public HttpStatusCategory getCategory() {
		return category;
	}

	/**
	 * Returns the default view for this status.
	 * @return the default view
	 */
	public HttpView getView() {
		return view;
	}



	/**
	 * Determines the HTTP status using the given code.
	 * @param code the code
	 * @return the parsed status
	 */
	public static HttpStatus parseVersion(int code) {
		for (HttpStatus st : values()) {
			if (st.code == code) return st;
		}
		return null;
	}

	/**
	 * Determines the HTTP status using the given status line.
	 * @param status the status line
	 * @return the parsed status
	 */
	public static HttpStatus parseVersion(String status) {
		for (HttpStatus st : values()) {
			if (st.status.equals(status)) return st;
		}
		return null;
	}

}
