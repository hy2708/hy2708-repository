package org.hy.commons.db.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Connection connection = JDBCUtils.getConnection();
    	connection.setAutoCommit(false);
    	Statement stmt =connection.createStatement();
    	stmt.executeUpdate("drop table if  exists users;");
    	stmt.executeUpdate("create table users(id varchar(32) primary key,name varchar(32),age int);");
    	connection.commit();
    	JDBCUtils.closeResource(connection, stmt, null);
    	
    }
}
