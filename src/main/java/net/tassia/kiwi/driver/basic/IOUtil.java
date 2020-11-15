package net.tassia.kiwi.driver.basic;

import net.tassia.kiwi.Kiwi;
import net.tassia.kiwi.Request;
import net.tassia.kiwi.Response;
import net.tassia.kiwi.enums.Method;
import net.tassia.kiwi.enums.Version;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

class IOUtil {

	static final String REGEX_FIRST_LINE = "";
	static final byte CR, LF;
	static final byte[] CRLF;
	static {
		assert "\r".getBytes(Kiwi.HEADER_CHARSET).length == 1;
		assert "\n".getBytes(Kiwi.HEADER_CHARSET).length == 1;
		CR = "\r".getBytes(Kiwi.HEADER_CHARSET)[0];
		LF = "\n".getBytes(Kiwi.HEADER_CHARSET)[0];
		CRLF = new byte[] { CR, LF };
	}

	static Request readRequestV1(InputStream in) throws IOException {
		final int bufferSize = 512;

		// Read status line
		String statusLine = readBufferedLineUntilCLRF(in, bufferSize);
		if (statusLine == null) throw new IllegalArgumentException("Invalid status line.");

		String[] statusLineParts = statusLine.split(" ");
		if (statusLineParts.length != 3) throw new IllegalArgumentException("Invalid status line: " + statusLine);

		Method method = Method.parseMethod(statusLineParts[0]);
		if (method == null) throw new IllegalArgumentException("Invalid method: " + statusLineParts[1]);

		String path = statusLineParts[1];

		Version version = Version.parseVersion(statusLineParts[2]);
		if (version == null) throw new IllegalArgumentException("Invalid version: " + statusLineParts[2]);

		// Read headers
		Map<String, String> headers = new HashMap<>();
		while (true) {
			String headerLine = readBufferedLineUntilCLRF(in, bufferSize);
			if (headerLine == null) throw new IllegalArgumentException("Invalid headers.");
			if (headerLine.isBlank()) break;
			// TODO
		}

		// Read payload
		byte[] payload = new byte[0];

		// Return
		return new SimpleRequest(method, path, version, payload, headers);
	}

	static void writeRequestV1(OutputStream out, Response response) throws IOException {
		// Write status line
		String statusLine = Version.HTTP_1_1.name() + " " + response.getStatus().getCode() + " " + response.getStatus().getStatusText();
		out.write(statusLine.getBytes(Kiwi.HEADER_CHARSET));
		out.write(CRLF);

		// Write headers
		for (Map.Entry<String, String> header : response.getHeaders().entrySet()) {
			String line = header.getKey() + ": " + header.getValue();
			out.write(line.getBytes(Kiwi.HEADER_CHARSET));
			out.write(CRLF);
		}
		out.write(CRLF);

		// Write payload
		if (response.getPayload() != null) {
			out.write(response.getPayload());
		}
	}

	static String readBufferedLineUntilCLRF(InputStream in, int bufferSize) throws IOException {
		byte[] buffer = new byte[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			buffer[i] = (byte) in.read();
			if (i >= 1 && buffer[i - 1] == CR && buffer[i] == LF) {
				return new String(buffer, 0, i - 1);
			}
		}
		return null;
	}

}
