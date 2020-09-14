package net.tassia.kiwi;

import java.util.Objects;

public class StaticAsset {
	protected byte[] data;
	protected String contentType;
	protected String charset;

	/* Constructor */
	/**
	 * TODO
	 */
	public StaticAsset(byte[] data, String contentType, String charset) {
		// Set data
		Objects.requireNonNull(data, "data must not be null");
		this.data = data;

		// Set content type
		Objects.requireNonNull(contentType, "contentType must not be null");
		this.contentType = contentType;

		// Set charset
		Objects.requireNonNull(charset, "charset must not be null");
		this.charset = charset;
	}
	/* Constructor */





	/* Getters */
	/**
	 * TODO
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * TODO
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * TODO
	 */
	public String getCharset() {
		return charset;
	}
	/* Getters */

}
