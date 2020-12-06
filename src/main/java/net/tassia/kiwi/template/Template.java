package net.tassia.kiwi.template;

public class Template implements TemplateToken {

	private final String name;
	private final TemplateToken[] tokens;

	public Template(String name, TemplateToken...tokens) {
		this.name = name;
		this.tokens = tokens;
	}

	public String getName() {
		return name;
	}

	public TemplateToken[] getTokens() {
		return tokens;
	}

	@Override
	public String getHTML(TemplateContext ctx) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!-- " + name + " OPEN -->");
		for (TemplateToken token : tokens) {
			sb.append(token.getHTML(ctx));
		}
		sb.append("<!-- " + name + " CLOSE -->");
		return sb.toString();
	}

}
