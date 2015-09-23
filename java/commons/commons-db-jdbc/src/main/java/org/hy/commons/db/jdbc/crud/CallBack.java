package org.hy.commons.db.jdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public interface CallBack {
	//public void doInConnection(Connection connection,PreparedStatement stmt,ResultSet rs);
	public void doInConnection(ResultSet rs);
}
