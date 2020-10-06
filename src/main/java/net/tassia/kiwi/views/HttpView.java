package net.tassia.kiwi.views;

public abstract class HttpView {
	private final String contentType, charset;

	public HttpView(String contentType, String charset) {
		this.contentType = contentType;
		this.charset = charset;
	}

	public String getContentType() {
		return contentType;
	}

	public String getCharset() {
		return charset;
	}

	public abstract byte[] getData();



	public static HttpView createStatic(String contentType, String charset, byte[] data) {
		return new HttpView(contentType, charset) {
			@Override
			public byte[] getData() {
				return data;
			}
		};
	}

}
