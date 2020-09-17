package examples;

import net.tassia.kiwi.Kiwi;
import net.tassia.kiwi.driver.sun.KiwiSunDriver;

import java.io.IOException;

public class SimpleServer {

	public static void main(String[] args) {
		Kiwi kiwi = new Kiwi();

		try {
			kiwi.setDriver(new KiwiSunDriver(kiwi));
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		}

		kiwi.GET("\\/hello", (kiwi1, request, response, matches) -> {
			return "Hello World!".getBytes();
		});

		kiwi.start();
	}

}
