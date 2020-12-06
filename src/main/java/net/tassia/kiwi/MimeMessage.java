package net.tassia.kiwi;

import net.tassia.kiwi.media.MediaType;

import java.nio.charset.Charset;
import java.util.Map;

public abstract class MimeMessage {

	public abstract void setHeaders(Map<String, String> headers);
	public abstract Map<String, String> getHeaders();

	public abstract void setHeader(String header, String value);
	public abstract void unsetHeader(String header);

	public abstract String getHeader(String key);
	public abstract boolean hasHeader(String key);



	public MediaType getMediaType() {
		if (hasHeader("Content-Type")) {
			return MediaType.fromHeaderString(getHeader("Content-Type"));
		} else {
			return null;
		}
	}

	public void setMediaType(MediaType mediaType) {
		setHeader("Content-Type", mediaType.toHeaderString());
	}

	public boolean isMimeType(String mimeType) {
		MediaType mediaType = getMediaType();
		return mediaType != null && mediaType.isMimeType(mimeType);
	}

	public Charset getCharset() {
		MediaType mediaType = getMediaType();
		return mediaType != null && mediaType.getCharset() != null ? mediaType.getCharset() : MediaType.ASCII;
	}

}
