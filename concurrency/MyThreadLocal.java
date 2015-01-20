package concurrency;

import dzone.com.*;


/**
 * this class acts as a container to our thread local variables.
 * @author vsundar
 *
 */
public class MyThreadLocal {

	public static final ThreadLocal<Integer> userThreadLocal = new ThreadLocal<>();

	public static void set(Integer user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Integer get() {
		return  userThreadLocal.get();
	}
}