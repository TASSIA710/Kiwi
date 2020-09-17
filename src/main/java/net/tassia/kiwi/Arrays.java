package net.tassia.kiwi;

public class Arrays {

	/* Contains */
	public static <T> boolean contains(T[] array, T element) {
		for (T e : array) {
			if (e.equals(element)) {
				return true;
			}
		}
		return false;
	}
	/* Contains */

}
