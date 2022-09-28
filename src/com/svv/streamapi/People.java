package com.svv.streamapi;

public class People {

	private final int age;
	private final Gender gender;
	private final String name;
	
	public People(int age, Gender gender, String name) {
		super();
		this.age = age;
		this.gender = gender;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "People [age=" + age + ", gender=" + gender + ", name=" + name + "]";
	}


}
