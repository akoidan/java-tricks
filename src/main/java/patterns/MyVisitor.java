package patterns;

import java.util.ArrayList;
import java.util.List;

interface Detail {
	void accept(Visitor visitor);
}


interface Visitor {
	void visit(Touchpad touchpad);
	void visit(Keyboard touchpad);
	void visit(Monitor touchpad);
}

class FixVisitor implements Visitor {

	@Override
	public void visit(Touchpad touchpad) {
		System.out.println("Fixing touch" + touchpad.getName());
		touchpad.setTouchName("fixed touch");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Fixing touch" + keyboard.getName());
		keyboard.setType("fixed key");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Fixing monitor" + monitor.getName());
		monitor.setModel("fixed monitor");
	}
}

class BreakVisitor implements Visitor {
	@Override
	public void visit(Touchpad touchpad) {
		System.out.println("Breacking touch" + touchpad.getName());
		touchpad.setTouchName(null);
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Breacking touch" + keyboard.getName());
		keyboard.setType(null);
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Breacking monitor" + monitor.getName());
		monitor.setModel(null);
	}
}


class Touchpad implements Detail {

	private String name;

	public String getName() {
		return name;
	}

	public void setTouchName(String name) {
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Keyboard implements Detail {

	public Keyboard() {
		this.name = "new";
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setType(String name) {
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Monitor implements Detail {

	private String name;

	public String getName() {
		return name;
	}

	public void setModel(String name) {
		this.name = name;
	}

	Monitor() {
		this.name = "new";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Laptop {


	private List<Detail> details;

	Laptop() {
		details = new ArrayList<>();
		details.add(new Keyboard());
		details.add(new Monitor());
		details.add(new Touchpad());
	}

	void visit(Visitor visitor) {
		for (Detail detail : details) {
			detail.accept(visitor);
		}

	}

}


public class MyVisitor {
	public static void main(String[] args) {
		Laptop lap = new Laptop();
		Visitor breakThings = new BreakVisitor();
		Visitor fixThings = new FixVisitor();
		lap.visit(breakThings);
		lap.visit(fixThings);
	}
}