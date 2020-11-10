package net.tassia.kiwi;

import java.util.Map;

public abstract class MimeMessage {

	public abstract Map<String, String> getHeaders();
	public abstract String getHeader(String key);
	public abstract boolean hasHeader(String key);
}
