package net.tassia.kiwi;

import java.io.InputStream;
import java.util.Map;

public abstract class MimeMessage {

	public abstract Map<String, String> getHeaders();
	public abstract String getHeader(String key);
	public abstract boolean hasHeader(String key);

	public abstract boolean hasPayload();
	public abstract int getPayloadLength();
	public abstract InputStream getPayloadStream();
	public abstract byte[] getPayload();

}
