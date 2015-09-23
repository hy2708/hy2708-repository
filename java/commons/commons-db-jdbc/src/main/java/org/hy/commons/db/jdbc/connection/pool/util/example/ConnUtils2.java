package org.hy.commons.db.jdbc.connection.pool.util.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnUtils2 implements Runnable{
	//声明一个容器,放所有声明的连接Connection
	private static List<Connection> pool = new ArrayList<Connection>();
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///test?characterEncoding=UTf8";
			for(int i=0;i<8;i++){
				//创建三个连接
				Connection con = DriverManager.getConnection(url,"root","root");
				System.err.println(con);
				//将这个三个连接放到pool中去
				pool.add(con);
			}
			System.err.println("连接是:"+pool);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	public static Connection getCon(){
		synchronized (pool) {
			Connection con = pool.remove(0);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("还有："+pool.size());
			return con;
		}
	}
	//手工的还连接
	public static void back(Connection con){
		System.err.println("还连接："+con);
		pool.add(con);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Class.forName(ConnUtils2.class.getName());
		 ConnUtils2 connUtils2= new ConnUtils2();
		new Thread(connUtils2).start();
		new Thread(connUtils2).start();
		new Thread(connUtils2).start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();

	}
	@Override
	public void run() {
		Connection connection = getCon();
		System.err.println(Thread.currentThread().getName() +"  "+connection);
		
	}
}
