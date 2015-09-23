package com.hy.designpatern.create.factorymethod;

import com.hy.designpatern.create.simplefactory.Product;

public interface Factory {
	public  Product produce(String productName) ;

}
