package net.tassia.kiwi.template;

import java.util.HashMap;
import java.util.Map;

public class TemplateContext {

	public final Map<String, String> replacements;

	public TemplateContext() {
		this(new HashMap<>());
	}

	public TemplateContext(Map<String, String> replacements) {
		this.replacements = replacements;
	}

}
