package net.tassia.kiwi.template;

interface TemplateToken {

	String getHTML();

	class HTMLToken {
	}

	class EscapedToken {
	}

	class UnescapedToken {
	}

}
