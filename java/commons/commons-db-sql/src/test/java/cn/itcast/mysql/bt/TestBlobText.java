package cn.itcast.mysql.bt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

public class TestBlobText {

	/**
	 * 保存带图片的数据
	 */
	@Test
	public void saveImage() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO bt_user (NAME,headimage) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "tom");
			InputStream inputStream = new FileInputStream("D:\\work\\Workspaces\\day14_jdbc\\src\\cn\\itcast\\mysql\\bt\\mm.jpg");
			pstmt.setBinaryStream(2, inputStream,inputStream.available());
			//mysql实现了所有方法，但有些方法执行无法通过，没有真正的实现
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取数据库带图片的一条记录
	 */
	@Test
	public void getImage() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select * from bt_user where id=1";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Blob blob = rs.getBlob("headimage");
				InputStream is = blob.getBinaryStream();
				String path = "D:\\work\\Workspaces\\day14_jdbc\\src\\cn\\itcast\\mysql\\bt\\mm2.jpg";
				OutputStream os = new FileOutputStream(path);
				byte[] buffer = new byte[1024];
				int len = -1;
				while((len=is.read(buffer))!=-1) {
					os.write(buffer, 0, len);
				}
				//os.flush();
				os.close();//close中有flush
				is.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
	
	/**
	 * 保存带文本的数据
	 */
	@Test
	public void saveText() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO bt_user (NAME,resume) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "tom2");
			String path = "D:\\work\\Workspaces\\day14_jdbc\\src\\cn\\itcast\\mysql\\bt\\工作.txt";
			InputStream is = new FileInputStream(path);
			Reader reader = new InputStreamReader(is,"utf-8");
			pstmt.setCharacterStream(2, reader, is.available());//只有字节点才能得到流数据中的字节数
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取数据库带文本的一条记录
	 */
	@Test
	public void getText() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select * from bt_user where id=2";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Reader reader = rs.getCharacterStream("resume");
				String path = "D:\\work\\Workspaces\\day14_jdbc\\src\\cn\\itcast\\mysql\\bt\\工作2.txt";
				BufferedReader br = new BufferedReader(reader);
				OutputStream os = new FileOutputStream(path);
				Writer writer = new OutputStreamWriter(os,"utf-8");
				String s = null;
				while((s=br.readLine())!=null) {
					writer.write(s);
					writer.write("\n");
				}
				writer.close();
				os.close();
				br.close();
				reader.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
}









