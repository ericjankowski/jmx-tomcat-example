package com.programeric;

import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName="bean:name=testBean", description="My Managed Bean")
public class AnnotationTestBean {

	private String name;
	private int age;

	@ManagedAttribute(description="The Age Attribute")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@ManagedAttribute(description="The Name Attribute", defaultValue="bar")
	public void setName(String name) {
		this.name = name;
	}

	@ManagedAttribute(defaultValue="foo")
	public String getName() {
		return name;
	}

	@ManagedOperation(description="Add two numbers")
	@ManagedOperationParameters({
		@ManagedOperationParameter(name = "x", description = "The first number"),
		@ManagedOperationParameter(name = "y", description = "The second number")})
	public int add(int x, int y) {
		return x + y;
	}

	public void dontExposeMe() {
		throw new RuntimeException();
	}
}