package org.hy.commons.db.metadata.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hy.commons.db.metadata.DBMetaDataUtil;

public class MapListHandler implements ResultSetHandler<List<Map<String, Object>>>{

	@Override
	public List<Map<String, Object>> handler(ResultSet rs) {
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();	
		List<String> tableColumnNames =DBMetaDataUtil.getTableColumnNames(rs);

		try {
			
			Map<String, Object> temp = null;
			while (rs.next()) {
				temp = new HashMap<String, Object>();
				for (String tableColumnName : tableColumnNames) {					
					temp.put(tableColumnName, rs.getObject(tableColumnName));
				}
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
