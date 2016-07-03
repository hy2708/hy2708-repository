package com.hy.designpatern.create.simplefactory;

public class FactoryOne {
  
	public static void main(String[] args) {
		FactoryOne factory = new FactoryOne();
		factory.produce("A");
		factory.produce("B");
	}
	
	
	public  Product produce(String productName) {
		Product a  = new ProductA();
		Product b = new ProductB();
		if(a.getName().equals(productName)){
			return a ;
		}else if(b.getName().equals(productName)){
			return b ;
		}
		throw new RuntimeException();
	}
}
