package com.hy.designpatern.create.factorymethod;

import com.hy.designpatern.create.simplefactory.Product;

public class ProductC implements Product{

	@Override
	public void say() {
		System.out.println("I am C");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "C";
	}
	
}
