package net.tassia.kiwi;

import net.tassia.kiwi.driver.KiwiDriver;

public class Kiwi {
	public static final int VERSION_MAJOR = 0;
	public static final int VERSION_MINOR = 0;
	public static final int VERSION_PATCH = 1;
	public static final int VERSION_BUILD = 1;
	private final KiwiDriver driver;

	/* Constructor */
	/**
	 * TODO
	 */
	public Kiwi(KiwiDriver driver) {
		this.driver = driver;
	}
	/* Constructor */





	/* Apply Middleware */
	/**
	 * TODO
	 */
	public void applyMiddleware() {
		// TODO
	}
	/* Apply Middleware */





	/* Server Name */
	/**
	 * TODO
	 */
	public String getServerName() {
		return "Kiwi/" + driver.getName() + " - " + VERSION_MAJOR + "." + VERSION_MINOR;
	}
	/* Server Name */

}
