package org.hy.commons.db.metadata.dbutil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hy.commons.db.metadata.DBMetaDataUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;


public class HibernateBeanListHandler<T> implements ResultSetHandler<List<T>>{
	
	Class<?> beanClass=null;
	public HibernateBeanListHandler(Class<?> beanClass) {
		super();
		this.beanClass = beanClass;
	}

	public List<T> handler(ResultSet rs){
		List<T> list = new LinkedList<T>();
		try {
			List<String> tableColumnNames =DBMetaDataUtil.getTableColumnNames(rs);
			while (rs.next()) {
				//T object = (T) Class.forName(T.getName()).newInstance();
				T object = (T) beanClass.newInstance();
				//String paramType = rs.getMetaData().getColumnClassName(0);
				//Class<?> paramTypeClass00 = Class.forName(paramType);
				Method[] methods = ReflectionUtil.getDeclaredAllMethods(object);

				//遍历所有set方法
				String methodName = null;
				for (Method method : methods) {
					methodName =method.getName();
					if (methodName.startsWith("set")) {	
						
						//从set方法中，截取变量名称，
						String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
						//如果表中，有，与之对应的字段
						
						if (tableColumnNames.contains(fieldName.toLowerCase())) {							
							//再重结果集中，获得数据
							//如果数据不是空
							//用反射调用set方法
							//Class<?> paramTypeClass = object.getClass().getMethod("g"+methodName.substring(1)).getReturnType();
							method.invoke(object, rs.getObject(fieldName));
						}
					}					
				}
				
				list.add(object);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}