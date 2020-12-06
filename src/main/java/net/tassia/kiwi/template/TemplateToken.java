package net.tassia.kiwi.template;

import net.tassia.kiwi.security.Escaping;

interface TemplateToken {

	String getHTML(TemplateContext ctx);



	class HTMLToken implements TemplateToken {
		private final String html;

		HTMLToken(String html) {
			this.html = html;
		}

		@Override
		public String getHTML(TemplateContext ctx) {
			return html;
		}
	}



	class EscapedToken implements TemplateToken {
		private final String name;

		EscapedToken(String name) {
			this.name = name;
		}

		@Override
		public String getHTML(TemplateContext ctx) {
			return Escaping.escapeXSS(ctx.replacements.get(name));
		}
	}



	class UnescapedToken implements TemplateToken {
		private final String name;

		UnescapedToken(String name) {
			this.name = name;
		}

		@Override
		public String getHTML(TemplateContext ctx) {
			return ctx.replacements.get(name);
		}
	}

}
