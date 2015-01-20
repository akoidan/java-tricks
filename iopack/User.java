package iopack;

import java.io.Serializable;

public class User implements Serializable{

	public String name;
	public int age;
	public Float growth;

	public User(String name, int age, float growth) {
		this.name = name;
		this.age = age;
		this.growth = growth;
	}
	
	public User(){
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getGrowth() {
		return growth;
	}

	public void setGrowth(float growth) {
		this.growth = growth;
}
	
	
}
