package org.hy.commons.aop.proxy;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;
import org.hy.commons.lang.reflect.ReflectionUtil;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2015-1-6；时间：下午2:53:46</li>
 * <li>类型名称：PointcutUtil</li>
 * <li>设计目的：判读切入点表达式和目标类的目标方法，是否匹配（如果切入点表达式和目标类不匹配，将不再判断目标方法是否匹配）</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
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
		return match(expression,clazz, orginalMethod);
	}

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：判读切入点表达式和目标类的目标方法，是否匹配（如果切入点表达式和目标类不匹配，将不再判断目标方法是否匹配）</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-1-6；时间：下午2:55:20</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param expression
	 * @param orginalMethod
	 * @return
	 */
	public static Boolean match(String expression,Class<?> orginalClass ,Method orginalMethod) {
		
		//获得一个切入点表达式的解析器
		//TODO ???
		PointcutParser parser =
				PointcutParser.getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
		//String expression ="execution(* cn.itcast.spring0909.aop.xml.PersonDaoImpl.a*(..))";
		//得到解析后的表达式
		PointcutExpression pointcutExpression  =parser.parsePointcutExpression(expression);
		//Method orginalMethod = ReflectionUtil.getDeclaredMethod(claszz, methodName, parameterTypes);//ReflectionUtil.getDeclaredMethod(Class.class, "getPerson");
		Method targetMethod = orginalMethod;//AopUtils.getMostSpecificMethod(method, targetClass);
		//如果切入点表达式和目标类不匹配，将不再判断目标方法是否匹配
		if (!pointcutExpression.couldMatchJoinPointsInType(orginalClass)) {
			return false;
		}//pointcutExpression.couldMatchJoinPointsInType(orginalClass);
		//targetMethod.get
		ShadowMatch shadowMatch =pointcutExpression.matchesMethodExecution(targetMethod);
		Boolean boolean1 =shadowMatch.alwaysMatches();
		return boolean1;
	}
	
	
}
