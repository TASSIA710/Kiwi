package net.tassia.kiwi;

import java.util.Map;

public abstract class MimeMessage {

	public abstract void setHeaders(Map<String, String> headers);
	public abstract Map<String, String> getHeaders();

	public abstract void setHeader(String header, String value);
	public abstract void unsetHeader(String header);

	public abstract String getHeader(String key);
	public abstract boolean hasHeader(String key);
}
