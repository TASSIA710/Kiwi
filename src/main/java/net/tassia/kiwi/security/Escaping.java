package net.tassia.kiwi.security;

/**
 * This is a utility class, used to sanitize possibly dangerous strings.
 */
public class Escaping {

	/**
	 * Private constructor.
	 */
	private Escaping() {
	}

	/**
	 * Escapes a string to make it cross site scripting safe. This method is confirm with the
	 * <a href="https://cheatsheetseries.owasp.org/cheatsheets/Cross_Site_Scripting_Prevention_Cheat_Sheet.html">
	 *     OWASP Cross Site Scripting Prevention Cheat Sheet</a>.
	 * @param input the string to escape
	 * @return the escaped string
	 */
	public static String escapeXSS(String input) {
		return EscapeXSS.escapeXSS(input);
	}

}
