package com.hy.designpatern.create.abstractfactory;

import com.hy.designpatern.create.simplefactory.FactoryOne;
import com.hy.designpatern.create.simplefactory.Product;
import com.hy.designpatern.create.simplefactory.ProductA;
import com.hy.designpatern.create.simplefactory.ProductB;

public class AbstractFactoryOne implements AbstractFactory{

	
	public static void main(String[] args) {
		AbstractFactoryOne factory = new AbstractFactoryOne();
		factory.produce("A");
		factory.produce("B");
		
		factory.producePhone("iPhone");
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

	@Override
	public Phone producePhone(String productName) {
		Phone a  = new PhoneA();
		Phone b = new PhoneB();
		if(a.getName().equals(productName)){
			return a ;
		}else if(b.getName().equals(productName)){
			return b ;
		}
		throw new RuntimeException();
	}

}
