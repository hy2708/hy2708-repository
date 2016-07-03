package org.hy.commons.lang.aop.proxy;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;
import org.hy.commons.lang.reflect.ReflectionUtil;

public class PointcutUtil {

	public static Boolean match(Map<String, String> expressions,Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		for (String key : expressions.keySet()) {
			if (match(expressions.get(key), clazz, methodName, parameterTypes)) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean match(String[] expressions,Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		for (String expression : expressions) {
			if (match(expression, clazz, methodName, parameterTypes)) {
				return true;
			}
		}
		return false;
	}

	public static Boolean match(Pointcut pointcut,Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		return match(pointcut.getExpression(), clazz, methodName, parameterTypes);
	}

	
	public static Boolean match(String expression,Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		Method orginalMethod = ReflectionUtil.getDeclaredMethod(clazz, methodName, parameterTypes);//ReflectionUtil.getDeclaredMethod(Class.class, "getPerson");
		return match(expression, orginalMethod);
	}

	
	public static Boolean match(String expression,Method orginalMethod) {
		
		PointcutParser parser =
				PointcutParser.getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
		//String expression ="execution(* cn.itcast.spring0909.aop.xml.PersonDaoImpl.a*(..))";
		PointcutExpression pointcutExpression  =parser.parsePointcutExpression(expression);
		//Method orginalMethod = ReflectionUtil.getDeclaredMethod(claszz, methodName, parameterTypes);//ReflectionUtil.getDeclaredMethod(Class.class, "getPerson");
		Method targetMethod = orginalMethod;//AopUtils.getMostSpecificMethod(method, targetClass);
		ShadowMatch shadowMatch =pointcutExpression.matchesMethodExecution(targetMethod);
		Boolean boolean1 =shadowMatch.alwaysMatches();
		System.err.println(boolean1);;
		return boolean1;
	}
}
