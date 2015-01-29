package spring;

import java.util.List;

public class Service {
	List myLol ;

  public Service() {
    System.out.println("Object Service has been created");
  }

  public void destroy() {
		System.out.println("Service has been destroyed");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize(); //To change body of generated methods, choose Tools | Templates.
		System.out.println("finnalize");
	}
	
	public void init(){
		System.out.println("init done");
	}

	public List getMyLol() {
		return myLol;
	}

	public void setMyLol(List myLol) {
		this.myLol = myLol;
	}
	
}
