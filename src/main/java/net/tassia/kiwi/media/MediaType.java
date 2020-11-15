package net.tassia.kiwi.media;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MediaType {

	public static final Charset UTF8 = StandardCharsets.UTF_8;
	public static final Charset ASCII = StandardCharsets.US_ASCII;

	public static final String TEXT_HTML = "text/html";
	public static final String TEXT_PLAIN = "text/plain";
	public static final String APPLICATION_JSON = "application/json";

	private final String mimeType;
	private final Charset charset;

	public MediaType(String mimeType, Charset charset) {
		this.mimeType = mimeType;
		this.charset = charset;
	}

	public String getMimeType() {
		return mimeType;
	}

	public Charset getCharset() {
		return charset;
	}

	public String toHeaderString() {
		return mimeType + "; charset=" + charset.name();
	}

	//public static MediaType fromHeaderString(String header) {
	//	TODO
	//}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MediaType) {
			return equals((MediaType) obj);
		} else {
			return false;
		}
	}

	public boolean equals(MediaType mediaType) {
		return mimeType.equals(mediaType.mimeType) && charset.equals(mediaType.charset);
	}

}
