package com;


/**
 * this class acts as a container to our thread local variables.
 * @author vsundar
 *
 */
public class MyThreadLocal {

	public static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<>();

	public static void set(Context user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Context get() {
		return  userThreadLocal.get();
	}
}