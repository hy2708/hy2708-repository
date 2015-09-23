package org.hy.commons.db.metadata.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UpdateHandler<T> {
	public T handler(Connection connection) throws SQLException ;
}
