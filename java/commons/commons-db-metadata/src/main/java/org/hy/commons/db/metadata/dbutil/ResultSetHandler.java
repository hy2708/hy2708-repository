package org.hy.commons.db.metadata.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetHandler<T> {
	public T handler(ResultSet rs) throws SQLException;
}
