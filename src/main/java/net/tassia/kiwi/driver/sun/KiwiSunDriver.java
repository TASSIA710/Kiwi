package net.tassia.kiwi.driver.sun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import net.tassia.kiwi.*;
import net.tassia.kiwi.Arrays;
import net.tassia.kiwi.driver.KiwiDriver;
import net.tassia.kiwi.middleware.Middleware;
import net.tassia.kiwi.route.HttpBasicRoute;
import net.tassia.kiwi.views.HttpView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.regex.Pattern;

public class KiwiSunDriver extends KiwiDriver {
	private final Kiwi kiwi;
	private final HttpServer server;
	private final List<HttpRouteInternal> routes;
	private final Map<String, StaticAsset> statics;

	/* Constructor */
	public KiwiSunDriver(Kiwi kiwi) throws IOException {
		super("Sun");
		this.kiwi = kiwi;
		this.server = HttpServer.create(new InetSocketAddress(kiwi.getOptions().port), kiwi.getOptions().backlog);
		this.routes = new ArrayList<>();
		this.statics = new HashMap<>();

		server.createContext("/", (exchange) -> {
			// Serve static assets
			if (exchange.getRequestMethod().equals("GET")) {
				String path = exchange.getRequestURI().getPath();
				StaticAsset staticAsset = statics.get(path);
				if (staticAsset != null) {
					exchange.getResponseHeaders().add("Content-Type", staticAsset.getContentType());
					exchange.getResponseHeaders().add("Accept-Charset", staticAsset.getCharset());
					exchange.sendResponseHeaders(200, staticAsset.getData().length);
					exchange.getResponseBody().write(staticAsset.getData());
					exchange.close();
					return;
				}
			}

			// Create response
			HttpResponse res = new HttpResponse(kiwi);

			try {
				// Create & dispatch request
				HttpRequest req = buildRequest(exchange);
				dispatchRequest(req, res);
			} catch (IOException ex) {
				ex.printStackTrace();
				res.setStatus(HttpStatus.STATUS_500);
				return;
			}

			// Prepare & send response
			try {
				res.setHeader("Server", kiwi.getServerName());

				exchange.getResponseHeaders().clear();
				for (Map.Entry<String, String[]> entry : res.getHeaders().entrySet()) {
					for (String value : entry.getValue()) {
						exchange.getResponseHeaders().add(entry.getKey(), value);
					}
				}

				byte[] data = res.getData();
				exchange.sendResponseHeaders(res.getCode(), data.length);
				exchange.getResponseBody().write(data);
				exchange.getResponseBody().flush();
				exchange.getResponseBody().close();

				exchange.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
	/* Constructor */





	/* Routes */
	protected void dispatchRequest(HttpRequest request, HttpResponse response) {
		for (HttpRouteInternal route : routes) {
			if (route.run(kiwi, request, response)) {
				return;
			}
		}
		response.setStatus(HttpStatus.STATUS_404);
	}

	@Override
	public void MATCHES(String path, HttpBasicRoute route, HttpMethod[] methods, Middleware...middlewares) {
		HttpRouteInternal r = new HttpRouteInternal();

		r.path = path;
		r.pattern = Pattern.compile(path);
		r.route = route;
		r.middlewares = middlewares;

		r.methodGET = Arrays.contains(methods, HttpMethod.GET);
		r.methodPOST = Arrays.contains(methods, HttpMethod.POST);
		r.methodPUT = Arrays.contains(methods, HttpMethod.PUT);
		r.methodDELETE = Arrays.contains(methods, HttpMethod.DELETE);
		r.methodPATCH = Arrays.contains(methods, HttpMethod.PATCH);

		routes.add(r);
	}

	@Override
	public void serveStaticAsset(String path, StaticAsset asset) {
		statics.put(path, asset);
	}
	/* Routes */





	/* Start */
	@Override
	public void start() {
		server.start();
	}

	@Override
	public void stop() {
		server.stop(0);
	}

	@Override
	public boolean isRunning() {
		return false; // TODO
	}
	/* Start */





	/* Build Request */
	protected HttpRequest buildRequest(HttpExchange exchange) throws IOException {
		final HttpMethod method = HttpMethod.valueOf(exchange.getRequestMethod());
		final HttpVersion version = HttpVersion.parseVersion(exchange.getProtocol());
		final String fullPath = exchange.getRequestURI().getPath();

		final byte[] data;
		if (exchange.getRequestBody() != null) {
			data = exchange.getRequestBody().readAllBytes();
			exchange.getRequestBody().close();
		} else {
			data = null;
		}

		return new HttpRequest() {
			@Override
			public HttpMethod getMethod() {
				return method;
			}

			@Override
			public boolean isMethod(HttpMethod check) {
				return method == check;
			}

			@Override
			public HttpVersion getHttpVersion() {
				return version;
			}

			@Override
			public String getFullPath() {
				return fullPath;
			}

			@Override
			public String getPath() {
				return fullPath;
			}

			@Override
			public String getQueryString() {
				return "";
			}

			@Override
			public byte[] getPayload() {
				return data;
			}
		};
	}
	/* Build Request */

}
