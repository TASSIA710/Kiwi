package net.tassia.kiwi.template;

public class TemplateEngine {

	public String parseTemplate(Template template, TemplateContext ctx) {
		return template.getHTML(ctx);
	}

}
