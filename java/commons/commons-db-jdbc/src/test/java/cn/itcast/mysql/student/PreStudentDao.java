package cn.itcast.mysql.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 操作student的CRUD
 * 
 * @author Administrator
 * 
 */
public class PreStudentDao {

	/**
	 * 保存Student对象
	 */
	public void saveStudent(Student s) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "INSERT INTO student(id,NAME,sex,grade) VALUES(?,?,?,?)";// 带?的sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getSex());
			pstmt.setDouble(4, s.getGrade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}

	/**
	 * 更新一个Stduent对象所对应的一条记录
	 */
	public void updateStudent(Student s) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "UPDATE student SET NAME=?,sex=?,grade=? WHERE id=?";// 带?的sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getSex());
			pstmt.setDouble(3, s.getGrade());
			pstmt.setInt(4, s.getId());
			int result = pstmt.executeUpdate();
			System.out.println("update result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}

	/**
	 * 根据id删除某条记录
	 */
	public void deleteStudentById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from student where id=?";// 带?的sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			System.out.println("delete result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}

	/**
	 * 删除所有记录
	 */

	public void deleteAllStudents() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from student";// 带?的sql
			pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			System.out.println("delete all result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}

	/**
	 * 根据id查询其对应的一条记录，返回一个student对象
	 */
	public Student findStudentById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student s = null;
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id,NAME,sex,grade FROM student WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSex(rs.getString("sex"));
				s.setGrade(rs.getDouble("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, rs);
		}
		return s;
	}

	/**
	 * 查询所有记录，返回List<Student>
	 */
	public List<Student> findAllStudents() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = null;
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id,NAME,sex,grade FROM student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSex(rs.getString("sex"));
				s.setGrade(rs.getDouble("grade"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, rs);
		}
		return list;
	}
}











