package net.tassia.kiwi;

import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.enums.Version;

import java.io.OutputStream;

public abstract class Response extends MimeMessage {

	public abstract Version getVersion();
	public abstract Status getStatus();

	public abstract OutputStream openPayloadStream();
	public abstract void closePayloadStream();
	public abstract void setPayload(byte[] payload);

}
