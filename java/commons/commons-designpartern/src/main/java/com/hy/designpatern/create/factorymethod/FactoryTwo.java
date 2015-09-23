package com.hy.designpatern.create.factorymethod;

import com.hy.designpatern.create.simplefactory.Product;
import com.hy.designpatern.create.simplefactory.ProductA;
import com.hy.designpatern.create.simplefactory.ProductB;


public class FactoryTwo implements Factory{
  
	public static void main(String[] args) {
		Factory factory = new FactoryTwo();
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
		/*
		 * 相对于FactoryOne，新增加了一个产品ProductC
		 */
		else if(b.getName().equals(productName)){
			return b ;
		}
		throw new RuntimeException();
	}
}
