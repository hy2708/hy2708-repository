package cn.itcast.mysql.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import cn.itcast.oracle.util.OracleJDBCUtils;

/**
 * 用statement实现DQL的操作
 * @author Administrator
 *
 */
public class TestStatementResultSet2 {

	@Test
	public void testDQL() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = OracleJDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id,NAME,PASSWORD FROM s_user";
			//sql = "SELECT id,NAME as username,PASSWORD FROM s_user";
			//executeQuery得到包含所有匹配的数据对象 ResultSet实现类对象
			//跟Iterator类似
			rs = stmt.executeQuery(sql);
			
			//使用ResultSet
			//next(): 移到光标到下一位，在移动之前确定其返回值，看右边有没有数据，有就返回true,没有就返回false
			while(rs.next()) {
				//rs.getXXX()取光标左边的数据  
				//XXX跟字段类型一定要一致
				//通过下标取数据
				//columnIndex - 第一个列是 1，第二个列是 2，…… 
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				System.out.println("id="+id+" name="+name+" pwd="+pwd);
				
				//通过字段名取数据
				//大小写是否影响？没有影响，数据库看到的都会是大写，如果小写会自动转
				//如果使用了别名，必须用别名去取
				id = rs.getInt("Id");
				name = rs.getString("name");
				//name = rs.getString("username");
				pwd = rs.getString("password");
				System.out.println("--id="+id+" name="+name+" pwd="+pwd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, rs);
		}
	}
	
	@Test
	public void testIterator() {
		Set<String> set = new HashSet<String>();
		set.add("b");
		set.add("a");
		set.add("c");
		set.add("d");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
		}
	}
}













