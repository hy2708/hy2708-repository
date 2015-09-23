package org.hy.commons.lang;

import java.util.Map;

import jodd.typeconverter.Convert;
import jodd.typeconverter.TypeConverterManager;

public class ConvertUtil extends Convert{

	public static void main(String[] args) {
		//TypeConverterManager.register(type, typeConverter)
	}
	
	public static <T>T convertToSubClass(Object parent,Class<T> subClass) {
		Map<String, Object> map = BeanUtil.populateToMap(parent);
		
		Object target=null;
		try {
			target = subClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String propertyName :map.keySet()){
			System.err.println(propertyName+" "+map.get(propertyName));
			BeanUtil.setProperty(target, propertyName, map.get(propertyName));
		}
		return (T)target;
	}
}
