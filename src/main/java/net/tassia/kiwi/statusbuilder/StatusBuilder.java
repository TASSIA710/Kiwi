package net.tassia.kiwi.statusbuilder;

import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Status;

@FunctionalInterface
public interface StatusBuilder {

	Response buildStatusPage(Status status);

}
