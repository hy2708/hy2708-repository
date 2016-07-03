package org.hy.commons.lang;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hy.commons.lang.generic.GenericsUtils;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityBeanUtil {

	static Logger logger = LoggerFactory.getLogger(EntityBeanUtil.class);
	List<String> list = getEntityPropertyNames();
	
	static String[] firstName = new String[]{"张","刘","牛","李","吕","付"
		,"副","王","汪","赵","孔","谭","贪","夏侯","令狐","上官","欧阳"
		,"司马","诸葛","曹","关","孙","甘","花"};
	static String[] centerName = {"立","祝","共","都","高","陆","恶","人","达","玉","莫","靓","宇"};
	static String[] lastName = {"强","颖","备","亮","云","正","冲","兄弟","大","小","关"
		,"撒旦","立","玉","鱼","牛","泵","秒","米","个","鐜","惇","彦","另","琳","浩",
		"皓","永锋","明正","丽音","志峰","春"};

	public static List<String> getEntityMethodsWithGetPrefix() {
		List<String> list = getEntityPropertyNames();
		List<String> list2 = new ArrayList<String>();

		for (String string : list) {
			list2.add("get" + string);
		}
		return list2;

	}

	public static void assertEntityProperties(Object expected, Object actual,
			String[] propertyNames) {
		for (String propertyName : propertyNames) {
			Object object = EntityBeanUtil.invokeEntityMethod(expected,
					"get" + propertyName);
			Object object2 = EntityBeanUtil.invokeEntityMethod(actual,
					"get" + propertyName);

			if (object != null && object2 != null) {
				//=========================================
				//assertEquals(object, object2);
				
				//================================================
				logger.debug("对象【" + expected + "】的方法【" + "get" + propertyName
						+ "】的期望值是【" + object + "】，对象【" + actual + "】的方法【"
						+ "get" + propertyName + "】的实际值是【" + object2 + "】");
				throw new RuntimeException("0000000000000000");
			}
		}
	}

	public static void assertEntityProperties(Object expected, Object actual) {
		List<String> list = getEntityPropertyNames();
		assertEntityProperties(expected, actual,
				list.toArray(new String[list.size()]));
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-17；时间：下午6:20:00</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 *            实体类的类名
	 * @param length
	 *            要创建的实体类对应的对象的个数
	 * @return
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <X> List<X> createEntityOjbects(Class clazz, int length) {
		List<X> list = new ArrayList();
		for (int i = 0; i < length; i++) {
			list.add((X) createEntityOjbect(clazz, String.valueOf(i)));
		}
		return list;
	}

	/**
	 * @see #createEntityOjbect(Class, String, Map, Boolean)
	 */
	public static <X> X createEntityOjbect(Class<?> clazz) {
		return (X) createEntityOjbect(clazz, null, null, true);
	}

	/**
	 * @see #createEntityOjbect(Class, String, Map, Boolean)
	 */
	public static <X> X createEntityOjbect(Class<?> clazz,
			String entityObjectIndentifier) {
		return (X) createEntityOjbect(clazz, entityObjectIndentifier, null,
				true);
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-17；时间：下午6:59:44</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @param entityObjectIndentifier
	 *            实体类对象的主键值
	 * @param map
	 *            实体类对象的参数
	 * @param additional
	 * @return
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <X> X createEntityOjbect(Class clazz,
			String entityObjectIndentifier, Map<String, ?> map,
			Boolean additional) {
		// Class<T>
		Serializable object = null;
		try {
			object = (Serializable) Class.forName(clazz.getName())
					.newInstance();
			// ((Serializable)object).setId("sf"+i);
			/**
			 * 只获取当前类的方法，没有父类的方法
			 */
			// Method[] methods= clazz.getDeclaredMethods();
			/**
			 * 只获取当前类的方法，含有父类的方法
			 */
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					logger.debug(method.getName());
					// method.getReturnType().getName().equals(String.class.getName())
					Class[] parameterTypes = method.getParameterTypes();
					// 对制定的属性，进行赋值

					String tempPropertyName = method.getName().substring(3);
					String propertyName = tempPropertyName.substring(0, 1)
							.toLowerCase() + tempPropertyName.substring(1);
					if (map != null && parameterTypes != null// 参数不空
							&& parameterTypes.length == 1// 参数是一个
							&& (map.get(propertyName) != null)) {

						method.invoke(object, map.get(propertyName));

					}
					// 字符串属性赋值
					else if (parameterTypes != null// 参数不空
							&& parameterTypes.length == 1// 参数是一个
							&& parameterTypes[0].getName().equals(
									String.class.getName())) {
						/*
						 * if (additional) { method.invoke(object,
						 * method.getName()+entityObjectIndentifier);
						 * 
						 * } else {
						 * 
						 * method.invoke(object, entityObjectIndentifier); }
						 */
						method.invoke(object, method.getName().substring(3));

					}
					// int类型属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Integer.class.getName())) {
						method.invoke(object, Math.getExponent(Math.random()));

					}
					// Long类型属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Long.class.getName())) {
						method.invoke(object,
								Long.valueOf(Math.getExponent(Math.random())));

					}
					// double类型属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Double.class.getName())) {
						method.invoke(object, Math.random());

					}
					// float类型属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Float.class.getName())) {
						method.invoke(object, Float.valueOf(new Double(Math
								.random()).toString()));

					}

					// Date属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Date.class.getName())) {
						method.invoke(object, new Date());
						// 对其他类型的属性，不进行赋值
					} else {
						// System.err.println(method.getName());
					}
				}

			}

		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		return (X) object;

	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：由反射，动态创建 实体类对象<br>
	 * 注：只能对String 和 Date类型的属性</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-6-9；时间：上午08:46:39</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param <X>
	 * @param clazz
	 * @param i
	 *            要创建的对象个数
	 * @return
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	// public MyBaseModel createPojoOjbect(Class clazz,int i) throws
	// InstantiationException, IllegalAccessException, ClassNotFoundException,
	// IllegalArgumentException, InvocationTargetException {
	public static <X> X createPojoOjbect(Class clazz, int i) {
		// Class<T>
		Serializable object = null;
		try {
			object = (Serializable) Class.forName(clazz.getName())
					.newInstance();
			// ((Serializable)object).setId("sf"+i);
			Method[] methods = clazz.getDeclaredMethods();
			// Method[] methods= clazz.getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("set")) {
					//System.err.println(method.getName());
					// method.getReturnType().getName().equals(String.class.getName())
					Class[] parameterTypes = method.getParameterTypes();
					// 字符串属性赋值
					if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									String.class.getName())) {
						method.invoke(object, method.getName() + i);

					}
					// Date属性赋值
					else if (parameterTypes != null
							&& parameterTypes.length == 1
							&& parameterTypes[0].getName().equals(
									Date.class.getName())) {
						method.invoke(object, new Date());

					} else {
						// System.err.println(method.getName());
					}
				}

			}

		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		return (X) object;

	}

	public static List<String> getEntityPropertyNames() {
		List<String> list = new ArrayList<String>();
		list.add("name");
		list.add("username");
		list.add("sex");
		list.add("birth");
		list.add("birthday");
		list.add("age");
		list.add("account");
		list.add("password");

		return list;

	}
	
	public static List<String> getEntityPropertyNames(Class<?> clazz) {
		List<String> propertyNames = new ArrayList<String>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				if (ClassUtil.isBasicDataType(methodParameter)) {
					propertyNames.add(fieldName);							
				}
//				else if (methodParameter.equals(HashSet.class)) {
//					Type associateClassType =methodParameter.getGenericInterfaces()[0];
//					Class<?> associateClass =ClassUtil.classOfType(associateClassType);
//				}
				else {
					propertyNames.add(fieldName);							
					//throw new RuntimeException("44444444444444");
				}
			}					
		}

		return propertyNames;

	}
	
	public static List<String> getBasePropertyNamesOfEntity(Class<?> clazz) {
		List<String> propertyNames = new ArrayList<String>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				if (ClassUtil.isBasicDataType(methodParameter)) {
					propertyNames.add(fieldName);							
				}
//				else if (methodParameter.equals(HashSet.class)) {
//					Type associateClassType =methodParameter.getGenericInterfaces()[0];
//					Class<?> associateClass =ClassUtil.classOfType(associateClassType);
//				}
				else {
					//propertyNames.add(fieldName);							
					//throw new RuntimeException("44444444444444");
				}
			}					
		}

		return propertyNames;

	}
	
	public static Map<String,Class> getBasePropertyNamesAndTypesOfEntity(Class<?> clazz) {
		Map<String,Class> propertyNames = new HashMap<String,Class>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				if (ClassUtil.isBasicDataType(methodParameter)) {
					propertyNames.put(fieldName, methodParameter);							
				}
//				else if (methodParameter.equals(HashSet.class)) {
//					Type associateClassType =methodParameter.getGenericInterfaces()[0];
//					Class<?> associateClass =ClassUtil.classOfType(associateClassType);
//				}
				else {
					//propertyNames.add(fieldName);							
					//throw new RuntimeException("44444444444444");
				}
			}					
		}

		return propertyNames;

	}
	
	public static List<Class> getCollectionPropertyNamesOfEntity(Class<?> clazz) {
		List<Class> propertyNames = new ArrayList<Class>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				
				if (ClassUtil.isCollectionDataType(methodParameter)) {
					
					List<Class> list =GenericsUtils.getMethodGenericParameterTypes(method);
					
					
					propertyNames.add(list.get(0));							

				}
				
			}
		}
		return propertyNames;
	}
	
	public static Map<String,Class> getCollectionPropertyNamesAndTypesOfEntity(Class<?> clazz) {
		//List<Class> propertyNames = new ArrayList<Class>();
		Map<String,Class> propertyNames = new HashMap<String,Class>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				
				if (ClassUtil.isCollectionDataType(methodParameter)) {
					
					List<Class> list =GenericsUtils.getMethodGenericParameterTypes(method);
										
					propertyNames.put(fieldName,list.get(0));							

				}
				
			}
		}
		return propertyNames;

	}
	public static List<Class> getObjectPropertyNamesOfEntity(Class<?> clazz) {
		List<Class> propertyNames = new ArrayList<Class>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				if (ClassUtil.isBasicDataType(methodParameter)) {
				}
				else if (ClassUtil.isCollectionDataType(methodParameter)) {					
				}
				else {
					propertyNames.add(methodParameter);							
				}
			}					
		}

		return propertyNames;

	}

	
	public static Map<String,Class> getObjectPropertyNamesAndTypesOfEntity(Class<?> clazz) {
		//List<Class> propertyNames = new ArrayList<Class>();
		Map<String,Class> propertyNames = new HashMap<String,Class>();

		Method[] methods = ReflectionUtil.getDeclaredAllMethods(clazz);

		//遍历所有set方法
		String methodName = null;
		for (Method method : methods) {
			//Method method = method;
			methodName =method .getName();
			if (methodName.startsWith("set")) {	
				
				//从set方法中，截取变量名称，
				String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
				Class<?> methodParameter =ClassUtil.classOfType(method.getParameterTypes()[0]);
				//如果表中，有，与之对应的字段
				if (ClassUtil.isBasicDataType(methodParameter)) {
				}
				else if (ClassUtil.isCollectionDataType(methodParameter)) {					
				}
				else {
					propertyNames.put(fieldName,methodParameter);							
				}
			}					
		}

		return propertyNames;

	}

	
	
	public static List<String> getEntityMethodsWithSetPrefix() {
		List<String> list = getEntityPropertyNames();
		List<String> list2 = new ArrayList<String>();

		for (String string : list) {
			list2.add("set" + string);
		}
		return list2;

	}

	public static <X> X invokeEntityMethod(Object entity, String methodName) {
		return (X) invokeEntityMethod(entity, methodName, null);
	}

	public static <X> X invokeEntityMethod(Object entity, String methodName,
			Object... args) {
		// Class<T>
		try {

			/**
			 * 只获取当前类的方法，没有父类的方法
			 */
			// Method[] methods= clazz.getDeclaredMethods();
			/**
			 * 只获取当前类的方法，含有父类的方法
			 */
			Method[] methods = entity.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equalsIgnoreCase(methodName)) {
					// logger.debug(method.getName());
					// method.getReturnType().getName().equals(String.class.getName())
					Class[] parameterTypes = method.getParameterTypes();
					// 对制定的属性，进行赋值

					String tempPropertyName = method.getName().substring(3);
					String propertyName = tempPropertyName.substring(0, 1)
							.toLowerCase() + tempPropertyName.substring(1);
					if ((parameterTypes == null || parameterTypes.length == 0)
							&& (args == null || args.length == 0)) {
						return (X) method.invoke(entity);
					} else if (parameterTypes != null// 参数不空
							&& parameterTypes.length == args.length// 参数是一个
					) {
						Boolean flag = true;
						for (int i = 0; i < parameterTypes.length; i++) {
							if (!parameterTypes[i].equals(args[i].getClass())) {
								flag = false;
							}
						}
						if (flag) {
							return (X) method.invoke(entity, args);
						}

					} else {
						logger.debug("ssssssssssss");
					}

				}

			}
			return null;

		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void printEntities(List list) {
		for (Object object : list) {
			printEntityProperties(object);
		}
	}

	public static void printEntityProperties(Object entity) {

		try {
			// Method[] methods = entity.getClass().getDeclaredMethods();
			/**
			 * 只获取当前类的方法，含有父类的方法
			 */
			Method[] methods = entity.getClass().getMethods();
			logger.debug("===============================================");
			logger.debug("打印对象【" + entity.toString() + "】属性信息");

			for (Method method : methods) {
				if (method.getName().startsWith("get")
						&& (!method.getName().startsWith("getClass"))) {
					// logger.debug(method.getName());
					// method.getReturnType().getName().equals(String.class.getName())
					Class[] parameterTypes = method.getParameterTypes();
					Object returnValue = null;
					// 字符串属性赋值
					if (parameterTypes == null || parameterTypes.length == 0) {
						returnValue = method.invoke(entity, null);
						String propertyName = method.getName().substring(2 + 1);
						logger.debug("属性名称:" + propertyName + " ,属性值:"
								+ returnValue);
					}

				}

			}

		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}

	}

	@Deprecated
	public void printPojoObject(List list) {
		for (Object object : list) {

			// System.err.println(object);
			// for (String propertyName :
			// ((BaseModel)object).getPropertyNames()) {
			// logger.debug("属性名称:"+propertyName+",属性值:"+((BaseModel)object).get(propertyName));
			// }

		}
	}

	/*
	 * public void printPojoObject(BaseModel object) {
	 * 
	 * System.err.println(object); for (String propertyName :
	 * ((BaseModel)object).getPropertyNames()) {
	 * logger.debug("属性名称:"+propertyName
	 * +",属性值:"+((BaseModel)object).get(propertyName)); }
	 * 
	 * }
	 */
	
	/*
	 * 返回 0或者1
	 */
	public static Integer randomInteger() {
		return randomInteger(2);
	}
	
	public static Integer randomInteger(Integer n) {
		return RandomUtil.nextInt(n);
	}
	
	public static String randomEMail() {
		String[] surffixs =new String[]{"@gmail.com","@ymail.com","@qq.com","@163.com","@126.com","@sina.com",
				"@yahoo.com","@sohu.com","@hotmail.com"};
		int index = RandomUtil.nextInt(surffixs.length);
		return randomUsername()+surffixs[index];
	}
	
	
	public static Integer randomPersonAge() {
		Date today=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthString = randomBirthday();
		Date birthday =null;
		try {
			birthday = sdf.parse(birthString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return today.getYear()-birthday.getYear();
		
		
	}

	public static String randomPersonName() {

		Random ran = new Random();
		String[] name1 = new String[] { "孔", "张", "叶", "李", "叶入", "孔令", "张立",
				"陈", "刘", "牛", "夏侯", "令", "令狐", "赵", "母", "穆", "倪", "张毅", "称",
				"程", "王", "王志", "刘金", "冬", "吴", "马", "沈" };

		String[] name2 = new String[] { "凡", "课", "颖", "页", "源", "都", "浩", "皓",
				"西", "东", "北", "南", "冲", "昊", "力", "量", "妮", "敏", "捷", "杰",
				"坚", "名", "生", "华", "鸣", "蓝", "春", "虎", "刚", "诚" };

		String[] name3 = new String[] { "吞", "明", "敦", "刀", "备", "伟", "唯", "楚",
				"勇", "诠", "佺", "河", "正", "震", "点", "贝", "侠", "伟", "大", "凡",
				"琴", "青", "林", "星", "集", "财" };

		boolean two = ran.nextInt(50) >= 45 ? false : true;
		if (two) {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2;
			int n = ran.nextInt(10);
			if (n > 5) {
				n2 = name2[ran.nextInt(name2.length)];
			} else {
				n2 = name3[ran.nextInt(name3.length)];
			}
			return n1 + n2;
		} else {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2 = name2[ran.nextInt(name2.length)];
			String n3 = name3[ran.nextInt(name3.length)];
			return n1 + n2 + n3;
		}
	}
	
	public static String randomPersonSex() {

		String[] sexs = new String[]{"男","女"};
		Random ran = new Random();
		return sexs[ran.nextInt(2)];
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：随机获得出生日期</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-8；时间：下午8:44:19</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	public static String randomBirthday() {
		String begin = "1970-01-01";
		String end = "1995-12-30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = null;
		try {
			Date sd = sdf.parse(begin);
			Date ed = sdf.parse(end);
			long t = randomRange(sd.getTime(), ed.getTime());
			Date d = new Date(t);
			str = sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static long randomRange(long start,long end) {
		return (long)(Math.random()*(end-start)+start);
	}
	
	public static String randomSex() {
		if (RandomUtil.nextInt(2)==0) {			
			return "male";
		} else {
			return "female";
		}
	}
	
	public static String randomUsername() {
		return RandomUtil.getRandomString(5);
	}

	public static <X> X setValueForEntityMethod(Object entity, String methodName) {
		return (X) setValueForEntityMethod(entity, methodName, methodName);
	}

	public static <X> X setValueForEntityMethod(Object entity,
			String methodName, Object methodArg) {
		return (X) invokeEntityMethod(entity, methodName, methodArg);
	}

	public static <X> X setValueForEntityMethods(Object entity) {
		List<String> list2 = getEntityMethodsWithSetPrefix();
		for (String string : list2) {
			setValueForEntityMethod(entity, string, string);
		}

		return null;
	}

}
