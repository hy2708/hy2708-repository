package com.hy.designpatern.create.simplefactory;

public class ProductA implements Product{

	@Override
	public void say() {
		System.out.println("I am A");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "A";
	}
	
}
