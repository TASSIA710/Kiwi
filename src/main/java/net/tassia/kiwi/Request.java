package net.tassia.kiwi;

import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.enums.Version;

import java.io.InputStream;

public abstract class Request extends MimeMessage {

	public abstract Method getMethod();
	public abstract Version getVersion();

	public abstract String getFullRequestPath();
	public abstract String getRequestPath();
	public abstract String getQueryString();

	public abstract boolean hasPayload();
	public abstract int getPayloadLength();
	public abstract InputStream getPayloadStream();
	public abstract byte[] getPayload();


}
