package net.tassia.kiwi;

import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.enums.Version;

public abstract class Request extends MimeMessage {

	public abstract Method getMethod();
	public abstract Version getVersion();

	public abstract String getFullRequestPath();

	public abstract boolean hasPayload();
	public abstract int getPayloadLength();
	public abstract byte[] getPayload();

	public boolean isMethod(Method method) {
		return getMethod() == method;
	}


}
