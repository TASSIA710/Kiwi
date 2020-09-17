package examples.simple_json;

import net.tassia.kiwi.HttpRequest;
import net.tassia.kiwi.HttpResponse;
import net.tassia.kiwi.Kiwi;
import net.tassia.kiwi.driver.sun.KiwiSunDriver;
import net.tassia.kiwi.route.JsonApiRoute;

import java.io.IOException;

public class SimpleJsonApi {

	public static void main(String[] args) {
		Kiwi kiwi = new Kiwi();

		try {
			kiwi.setDriver(new KiwiSunDriver(kiwi));
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		}

		kiwi.POST("\\/sum", new SumRoute());

		kiwi.start();
	}

	public static class SumRoute extends JsonApiRoute<SumRoute.RequestStructure> {

		public SumRoute() {
			super(RequestStructure.class);
		}

		@Override
		public Object onApiRequest(Kiwi kwi, HttpRequest request, HttpResponse response, String[] matches, SumRoute.RequestStructure payload) {
			ResponseStructure res = new ResponseStructure();
			res.sum = payload.x + payload.y;
			return res;
		}

		private static class RequestStructure {
			public double x;
			public double y;
		}

		private static class ResponseStructure {
			public double sum;
		}

	}

}
