package net.tassia.kiwi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Static Assets work differently to {@link HttpRequest}s. While HttpRequests are select by a RegEx matching the
 * request URI, and multiple middlewares being applied to both the request and response, a static asset is determined
 * by the request URI matching the exact path specified when registering this asset. Furthermore, absolutely no
 * middlewares are applied to static assets, and the router checks for a matching static asset before checking other
 * routes, making them a lot faster than routes.
 */
public class StaticAsset {
	protected byte[] data;
	protected String contentType;
	protected String charset;

	/* Constructor */
	/**
	 * Constructs a new static asset with the given properties.
	 * @param data the data (see {@link #getData()})
	 * @param contentType the content-type (see {@link #getContentType()}
	 * @param charset the charset (see {@link #getCharset()}
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
	 * Returns the actual data/body of this static asset.
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * Returns the content-type of this static asset (e.g. 'application/json').
	 * @return the content-type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Returns the charset of this static asset (e.g. 'utf8').
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}
	/* Getters */





	/* Static Creators */
	/**
	 * Uses the files path to create a new static asset using {@link #fromPath(Path, String, String)}
	 * @param file the file to use
	 * @param contentType the content-type (e.g. 'application/json')
	 * @param charset the charset (e.g. 'utf8')
	 * @return the created static asset
	 * @throws IOException if an I/O error occurs
	 */
	public static StaticAsset fromFile(File file, String contentType, String charset) throws IOException {
		return fromPath(file.toPath(), contentType, charset);
	}

	/**
	 * Creates a new static asset, using the given content-type and charset and reads all bytes from the specified
	 * {@link Path}, and uses that as data.
	 * @param path the path to read from
	 * @param contentType the content-type (e.g. 'application/json')
	 * @param charset the charset (e.g. 'utf8')
	 * @return the created static asset
	 * @throws IOException if an I/O error occurs
	 */
	public static StaticAsset fromPath(Path path, String contentType, String charset) throws IOException {
		return new StaticAsset(Files.readAllBytes(path), contentType, charset);
	}

	/**
	 * Works the same as {@link #fromResource(String, ClassLoader, String, String)}, but uses the class loader of
	 * {@link Kiwi}.
	 * @param resource the path to the resource
	 * @param contentType the content-type (e.g. 'application/json')
	 * @param charset the charset (e.g. 'utf8')
	 * @return the created static asset
	 * @throws IOException if an I/O error occurs
	 */
	public static StaticAsset fromResource(String resource, String contentType, String charset) throws IOException {
		return fromResource(resource, Kiwi.class.getClassLoader(), contentType, charset);
	}

	/**
	 * Creates a new static asset with the given content-type and charset and the resource as data
	 * (using {@link ClassLoader#getResourceAsStream(String)}.
	 * @param resource the path to the resource
	 * @param classLoader the class loader to use
	 * @param contentType the content-type (e.g. 'application/json')
	 * @param charset the charset (e.g. 'utf8')
	 * @return the created static asset
	 * @throws IOException if an I/O error occurs
	 */
	public static StaticAsset fromResource(String resource, ClassLoader classLoader, String contentType, String charset) throws IOException {
		InputStream in = classLoader.getResourceAsStream(resource);
		if (in == null) throw new IllegalArgumentException("Couldn't find resource: " + resource);
		StaticAsset asset = fromInputStream(in, contentType, charset);
		in.close();
		return asset;
	}

	/**
	 * Creates a new static asset with the given content-type and charset. This method reads all bytes from the input
	 * stream, until the stream ends.<br>
	 * <b>Note:</b> This method does not close the input stream.
	 * @param in the input stream
	 * @param contentType the content-type (e.g. 'application/json')
	 * @param charset the charset (e.g. 'utf8')
	 * @return the created static asset
	 * @throws IOException if an I/O error occurs
	 */
	public static StaticAsset fromInputStream(InputStream in, String contentType, String charset) throws IOException {
		return new StaticAsset(in.readAllBytes(), contentType, charset);
	}
	/* Static Creators */

}
