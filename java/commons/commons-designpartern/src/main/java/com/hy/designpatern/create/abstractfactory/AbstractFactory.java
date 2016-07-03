package com.hy.designpatern.create.abstractfactory;

import com.hy.designpatern.create.factorymethod.Factory;
import com.hy.designpatern.create.simplefactory.Product;

public interface AbstractFactory extends Factory{
	public  Phone producePhone(String productName) ;

}
