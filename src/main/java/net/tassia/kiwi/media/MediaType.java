package net.tassia.kiwi.media;

import javax.print.attribute.standard.Media;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MediaType {

	public static final Charset UTF8 = StandardCharsets.UTF_8;
	public static final Charset ASCII = StandardCharsets.US_ASCII;

	public static final String TEXT_HTML = "text/html";
	public static final String TEXT_PLAIN = "text/plain";
	public static final String APPLICATION_JSON = "application/json";

	public static final String REGEX_MIME_TYPE = "^[-\\w.]+/[-\\w.+]+$";

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

	public static MediaType fromHeaderString(String header) {
		if (header.matches(REGEX_MIME_TYPE)) {
			// ASCII is the default charset
			// See: https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types
			return new MediaType(header, ASCII);
		} else {
		}
		return null;
	}

	public boolean isMimeType(String mimeType) {
		return this.mimeType.equals(mimeType);
	}

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
