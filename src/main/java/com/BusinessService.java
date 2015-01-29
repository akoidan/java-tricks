package com;

public class BusinessService {

	public void businessMethod() {
		// get the context from thread local
//		Context context = MyThreadLocal.get();
		System.out.println(MyThreadLocal.get());
	}
}