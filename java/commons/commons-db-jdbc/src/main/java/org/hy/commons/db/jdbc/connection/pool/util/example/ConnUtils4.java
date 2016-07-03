package org.hy.commons.db.jdbc.connection.pool.util.example;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
public class ConnUtils4 {
	//第一步：声明连接池维护所有的连接
	private static List<Connection> pool = new ArrayList<Connection>();
	//第二步：静态代码块中创建多个连接
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///db909?characterEncoding=UTF8";
			for(int i=0;i<3;i++){
				final Connection con = DriverManager.getConnection(url,"root","1234");//com.mysql.jdbc.Jdbc4Connection@
				//对con对象进行动态代理
				Object proxyedCon = 
						Proxy.newProxyInstance(
								ConnUtils4.class.getClassLoader(),
								new Class[]{Connection.class},
								//声明执行句柄，只对close方法设置拦截
								new InvocationHandler() {
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										if(method.getName().equals("close")){
											System.err.println("有人想关闭连接，不能关，还连接");
											//将proxy再加到pool中,这个proxy就是proxyedCon
											synchronized (pool) {
												pool.add((Connection) proxy);
												pool.notify();
											}
											return null;
										}else{
											System.err.println("放行"+method.getName());
											return method.invoke(con, args);
										}
									}
								});
				//一定要将代理对象添加到池中去。
				pool.add((Connection) proxyedCon);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	/**
	 * 提供一个静态工厂方法返回一个连接
	 */
	public static Connection getCon(){
		synchronized (pool) {
			if(pool.size()==0){
				try {
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return getCon();
			}
			Connection con = pool.remove(0);//返回一个代理的connection对象
			System.err.println("还有几个:"+pool.size());
			return con;
		}
	}
}
