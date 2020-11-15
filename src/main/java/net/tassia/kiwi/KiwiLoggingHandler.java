package net.tassia.kiwi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class KiwiLoggingHandler extends Handler {

	private final String ANSI_INFO_LIGHT = "\u001B[38;2;0;0;0m";
	private final String ANSI_INFO_DARK = "\u001B[38;2;255;255;255m";
	private final String ANSI_WARNING = "\u001B[38;2;255;191;0m";
	private final String ANSI_SEVERE = "\u001B[101;93m";
	private final String ANSI_FINE = "\u001B[38;2;127;127;127m";

	private final boolean darkMode;

	public KiwiLoggingHandler(boolean darkMode) {
		this.darkMode = darkMode;
	}

	protected String getColor(Level level) {
		if (level== Level.INFO) {
			return darkMode ? ANSI_INFO_DARK : ANSI_INFO_LIGHT;
		} else if (level == Level.WARNING) {
			return ANSI_WARNING;
		} else if (level == Level.SEVERE) {
			return ANSI_SEVERE;
		} else if (level == Level.FINE) {
			return ANSI_FINE;
		} else if (level == Level.FINER) {
			return ANSI_FINE;
		} else if (level == Level.FINEST) {
			return ANSI_FINE;
		} else {
			return "\u001B[38;2;127;127;255m";
		}
	}

	protected final String ANSI_TERMINATOR = "\u001B[0m";

	@Override
	public void publish(LogRecord record) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		if (record.getThrown() != null) {
			record.getThrown().printStackTrace();
		}

		String format = String.format("%s | #%02x | %s: %s", sdf.format(new Date(record.getMillis())),
			record.getThreadID(), record.getLevel().getName(), record.getMessage());
		System.out.println(getColor(record.getLevel()) + format + ANSI_TERMINATOR);
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() throws SecurityException {
	}

}
