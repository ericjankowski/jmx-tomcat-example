package com.programeric;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName="bean:name=person", description="Managed Person Bean")
public class Person {

	private String name;
	private int age;

	@ManagedAttribute(description="Age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@ManagedAttribute(description="Name", defaultValue="George")
	public void setName(String name) {
		this.name = name;
	}

	@ManagedAttribute(defaultValue="George")
	public String getName() {
		return name;
	}
}