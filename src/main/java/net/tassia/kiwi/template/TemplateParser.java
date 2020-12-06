package net.tassia.kiwi.template;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TemplateParser {

	private int pos;
	private final String str;
	private final String name;
	private final Function<String, String> templateSupplier;

	private TemplateParser(String str, String name, Function<String, String> templateSupplier) {
		this.pos = 0;
		this.str = str;
		this.name = name;
		this.templateSupplier = templateSupplier;
	}

	public static Template parseTemplate(String str, String name, Function<String, String> templateSupplier) {
		return new TemplateParser(str, name, templateSupplier).readTemplate();
	}



	private Template readTemplate() {
		List<TemplateToken> tokens = new ArrayList<>();
		while (pos < str.length()) {
			if (Peek(2).equals("{{")) {
				tokens.add(readEscapedToken());
			} else if (Peek(2).equals("{!")) {
				tokens.add(readUnescapedToken());
			} else {
				tokens.add(readHTMLToken());
			}
		}
		return new Template(name, tokens.toArray(new TemplateToken[0]));
	}

	private TemplateToken.HTMLToken readHTMLToken() {
		StringBuilder sb = new StringBuilder();
		while (!Peek(2).equals("{{") && !Peek(2).equals("{!")) {
			sb.append(Peek());
			Next();
		}
		return new TemplateToken.HTMLToken(sb.toString());
	}

	private TemplateToken.EscapedToken readEscapedToken() {
		StringBuilder sb = new StringBuilder();
		Next("{{");
		while (!Peek(2).equals("}}")) {
			if (!Character.isWhitespace(Peek())) {
				sb.append(Peek());
			}
			Next();
		}
		Next("}}");
		return new TemplateToken.EscapedToken(sb.toString());
	}

	private TemplateToken.UnescapedToken readUnescapedToken() {
		StringBuilder sb = new StringBuilder();
		Next("{!");
		while (!Peek(2).equals("!}")) {
			if (!Character.isWhitespace(Peek())) {
				sb.append(Peek());
			}
			Next();
		}
		Next("!}");
		return new TemplateToken.UnescapedToken(sb.toString());
	}



	private char Peek() {
		return str.charAt(pos);
	}

	private String Peek(int len) {
		return str.substring(pos, pos + len);
	}

	private void Next() {
		Next(1);
	}

	private void Next(int len) {
		pos += len;
	}

	private void Next(char c) {
		assert Peek() == c;
		Next();
	}

	private void Next(String str) {
		assert Peek(str.length()).equals(str);
		Next(str.length());
	}

}
