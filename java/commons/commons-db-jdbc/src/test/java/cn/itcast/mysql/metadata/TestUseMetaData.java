package cn.itcast.mysql.metadata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 测试ResultSetMetaData的实际用途
 * 业务需要：
 * 	数据库中有user,teacher,student表，它们的字段不一样，现在需要完成将这三个表中的记录导出生成对应的xml文件
 * 　如：user表（id,name,password）会生成一个如下的文件
 * 　<users>
 * 		<user>
 * 			<id>1</id>
 * 			<name>Tom</Tom>
 * 			<password>123<password>
 * 		</user>
 * 		<user>
 * 			<id>2</id>
 * 			<name>cat</Tom>
 * 			<password>1234<password>
 * 		</user>
 *  </users>
 *  文件名为uers.xml 存放在d:/data目录下
 * @author Administrator
 *
 */
public class TestUseMetaData {

	@Test
	public void testSaveToXml() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String tableName = "student";
		
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from "+tableName;
			rs =stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			Document document = DocumentHelper.createDocument();
			Element rootElement = document.addElement(tableName+"s");
			
			while(rs.next()) {
				/*<user>
				 * <id>1</id>
				 * <name>Tom</Tom>
				 * <password>123<password>
				 * <user>
				 */
				Element tableElement = rootElement.addElement(tableName);
				for(int i=1;i<=columnCount;i++) {
					String columnName = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					Element element = tableElement.addElement(columnName);
					element.addText(value.toString());
				}
			}
			
			//写到指定的目录
			String filePath = "d:/data/"+tableName+"s.xml";
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(new FileOutputStream(filePath),format);
			writer.write(document);
			writer.flush();
			writer.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
