package org.hy.commons.lang.reflect.example.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hy.commons.lang.reflect.ReflectUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.hy.commons.lang.reflect.example.SimpleInterface;
import org.hy.commons.lang.reflect.example.SimpleObject;
/*
 * 这是 模拟JDK创建的 代理类
 */
public class $Proxy01 implements SimpleInterface{

	InvocationHandler handler = null;
	
	public static void main(String[] args) {
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				/*
				 * 会，死循环
				 */
				Object object = method.invoke(proxy, args);
				return object;
			}
		};
		SimpleInterface simpleInterface =(SimpleInterface) Proxy.newProxyInstance(SimpleObject.class.getClassLoader(), SimpleObject.class.getInterfaces(), h);
		/*
		 * 死循环
		 */
		simpleInterface.toString();
	}
	
	public $Proxy01(InvocationHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void work(String text) {
		
		Method method = ReflectionUtil.getDeclaredMethod(getClass(), "work", new Class[]{String.class});
		try {
			/*
			 * 如果 handler.invoke(this, method , new Object[]{text})的内部，
			 * 也使用了method.invoke(proxy, args)，
			 * 这样就会因为，自己调用自己，造成死循环
			 */
			handler.invoke(this, method , new Object[]{text});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

}
