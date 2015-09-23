package org.hy.commons.aop.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;
import org.hy.commons.lang.reflect.ReflectionUtil;
//import org.springframework.aop.support.AopUtils;

public class PointcutExpressionMatchTest {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-3-2；时间：下午9:20:30</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 */
	public static void main(String[] args) {
		//org.aspectj.weaver.patterns.Pointcut pointcut=null;
		org.aspectj.weaver.loadtime.definition.Definition.Pointcut pointcut =null;
		//pointcut.g
		PointcutParser parser =
				PointcutParser.getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
		String string ="execution(* *.*(..))";
		
		PointcutExpression pointcutExpression  =parser.parsePointcutExpression(string);
		
		Method orginalMethod = ReflectionUtil.getDeclaredMethod(Class.class, "getPerson");
		Method targetMethod = orginalMethod;//AopUtils.getMostSpecificMethod(method, targetClass);
		
		//pointcutExpression.couldMatchJoinPointsInType(arg0)
		ShadowMatch shadowMatch =pointcutExpression.matchesMethodExecution(targetMethod);
		System.err.println(shadowMatch.alwaysMatches());;
	}

}
