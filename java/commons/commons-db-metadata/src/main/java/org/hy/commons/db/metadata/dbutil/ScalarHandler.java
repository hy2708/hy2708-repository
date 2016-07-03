package org.hy.commons.db.metadata.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScalarHandler  implements ResultSetHandler<Integer>{

	@Override
	public Integer handler(ResultSet rs) throws SQLException {
		try {
			while (rs.next()) {
				//count(*) from t_xxx;
				
				return Integer.valueOf(rs.getInt(1));
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
