package cn.itcast.mysql.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.oracle.util.OracleJDBCUtils;

/**
 * 对student表进行CRUD操作
 * 
 * ＤＡＯ(Data access object)
 * 
 * 一个表会对应一个实现类
 * 
 * @author Administrator
 * 
 */
public class StudentDAO {

	/**
	 * 保存一个学生信息
	 * 
	 * @param s
	 */
	public void saveStudent(Student s) {
		Connection conn = null;
		Statement stmt = null;

		conn = OracleJDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO student(id,NAME,sex,grade) VALUES(" + s.getId() + ",'"
					+ s.getName() + "','" + s.getSex() + "'," + s.getGrade() + ")";
			int result = stmt.executeUpdate(sql);
			System.out.println("insert result=" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, null);
		}

	}

	/**
	 * 更新指定学生的信息
	 * 
	 * @param s
	 */
	public void updateStudent(Student s) {
		Connection conn = null;
		Statement stmt = null;

		conn = OracleJDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE student SET NAME='" + s.getName() + "',sex='" + s.getSex()
					+ "',grade=" + s.getGrade() + " WHERE id=" + s.getId();
			int result = stmt.executeUpdate(sql);
			System.out.println("update result=" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, null);
		}
	}

	/**
	 * 根据id去删除它所对应的表数据
	 * 
	 * @param id
	 */
	public void deleteStudentById(int id) {
		Connection conn = null;
		Statement stmt = null;

		conn = OracleJDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM student WHERE id=" + id;
			int result = stmt.executeUpdate(sql);
			System.out.println("delete result=" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, null);
		}
	}

	/**
	 * 删除student表中所有的记录
	 */
	public void deleteAllStudents() {
		Connection conn = null;
		Statement stmt = null;

		conn = OracleJDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM student";
			int result = stmt.executeUpdate(sql);
			System.out.println("delete all result=" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, null);
		}
	}

	/**
	 * 根据id查询所匹配的记录，返回Student对象（可能为null）;
	 * 
	 * @param id
	 * @return
	 */
	public Student findStudentById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Student s = null;

		conn = OracleJDBCUtils.getConnection();

		try {
			stmt = conn.createStatement();
			String sql = "SELECT id,NAME,sex,grade FROM student WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				s = new Student();
				s.setId(id);
				s.setName(rs.getString("name"));
				s.setSex(rs.getString("sex"));
				s.setGrade(rs.getDouble("grade"));
			} else {
				// 没有工作可做
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, rs);
		}

		return s;
	}

	/**
	 * 查询得到student表中所有的数据，返回一个List<Student>类型的对象
	 * 
	 * @return
	 */
	public List<Student> findAllStudents() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();

		conn = OracleJDBCUtils.getConnection();

		try {
			stmt = conn.createStatement();
			String sql = "SELECT id,NAME,sex,grade FROM student";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
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
			OracleJDBCUtils.closeResource(conn, stmt, rs);
		}

		return list;
	}
}
