package com.hy.designpatern.create.factorymethod;

import com.hy.designpatern.create.simplefactory.Product;

public class ProductD implements Product{

	@Override
	public void say() {
		System.out.println("I am D");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "D";
	}
	
}
