package net.tassia.kiwi;

import net.tassia.kiwi.enums.Status;
import net.tassia.kiwi.enums.Version;

public abstract class Response extends MimeMessage {

	public abstract Version getVersion();
	public abstract Status getStatus();

}
