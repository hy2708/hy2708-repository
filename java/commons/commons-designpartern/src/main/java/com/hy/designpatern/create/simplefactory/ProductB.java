package com.hy.designpatern.create.simplefactory;

public class ProductB implements Product{

	@Override
	public void say() {
		System.out.println("I am B");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "B";
	}
	
}
