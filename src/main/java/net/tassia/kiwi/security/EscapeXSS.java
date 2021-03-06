package net.tassia.kiwi.security;

class EscapeXSS {

	/**
	 * HTML Encode Before Inserting Untrusted Data into HTML Element Content
	 * @see <a href="https://cheatsheetseries.owasp.org/cheatsheets/Cross_Site_Scripting_Prevention_Cheat_Sheet.html">
	 *     OWASP Cross Site Scripting Prevention Cheat Sheet</a>
	 * @param input the string to escape
	 * @return the escaped string
	 */
	protected static String escapeXSS(String input) {
		input = input.replace("&", "&amp;"); // & --> &amp;
		input = input.replace("<", "&lt;"); // < --> &lt;
		input = input.replace(">", "&gt;"); // > --> &gt;
		input = input.replace("\"", "&quot;"); // " --> &quot;
		input = input.replace("'", "&#x27;"); // ' --> &#x27;
		input = input.replace("/", "&#x2F;"); // / --> &#x2F;
		return input;
	}

}
