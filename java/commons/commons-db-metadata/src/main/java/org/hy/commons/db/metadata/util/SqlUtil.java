package org.hy.commons.db.metadata.util;

//import gudusoft.gsqlparser.EDbVendor;
//import gudusoft.gsqlparser.TGSqlParser;
//import gudusoft.gsqlparser.nodes.TResultColumn;
//import gudusoft.gsqlparser.nodes.TResultColumnList;
//import gudusoft.gsqlparser.stmt.TSelectSqlStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Deprecated
public class SqlUtil {

	public static void main(String[] args) {
		String sql ="select from t_user ";
		int begin =sql.indexOf("from ")+4;
		System.err.println(sql.indexOf("from "));
		int end =sql.indexOf(" ",begin);
		String tableName = sql.substring(begin,end);
		System.err.println(tableName);
		getTableName(sql);
		
	}
	
	public static String getTableName(String sql) {
		String str = "INSERT INTO A\n" +  
			    "SELECT B.B1, B.B2, C.C1, C.C2\n" +  
			    "FROM B INNER JOIN C ON B.B0 = C.C0\n" +  
			    "WHERE B.B0 IN (SELECT D0 FROM D,E,G,H WHERE D.D1 = E.E1) \n";  
			Pattern p = Pattern  
			    .compile(  
			        "(?i)(?<=(?:from|into|update|join)\\s{1,1000}"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?" // 重复这里, 可以多个from后面的表  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"  
			        + ")(\\w+)"  
			        );  
//			Matcher m = p.matcher(str);  
			Matcher m = p.matcher(sql);  
			List<String>   tables = new ArrayList<String>();  
			while (m.find()) {  
			  tables.add(m.group());  
			}  
			
			//System.out.println(tables);  
			return tables.get(0);
	}
	
//	private static void name() {
//		  TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvoracle);
//	        sqlparser.sqltext = " SELECT\n" +
//	                "   NVL(SUM(MISSIONNO), 0) DISTCNT, COUNT(DISTINCT(USERID)) USERIDCNT\n" +
//	                "  FROM EVTSUPPLYHIST\n" +
//	                " WHERE EVTCODE = #evtCode#\n" +
//	                "   AND EVTNO = #evtNo#\n" +
//	                "   AND GIFTCODE = #giftCode#\n" +
//	                "   AND SUPPLYDT BETWEEN TO_DATE(#startDate#, 'YYYY/MM/DD HH24:MI:SS') \n" +
//	                "   AND TO_DATE(#endDate#, 'YYYY/MM/DD HH24:MI:SS')";
//	        int ret = sqlparser.parse();
//	        if (ret == 0) {
//	            TSelectSqlStatement select = (TSelectSqlStatement) sqlparser.sqlstatements.get(0);
//	            TResultColumnList columnList = select.getResultColumnList();
//	            for (int i = 0; i < columnList.size(); i++) {
//	                TResultColumn col = columnList.getResultColumn(i);
//	                if (col.getAliasClause() != null) { //别名列
//	                    System.out.println(col.getAliasClause().toString());
//	                } else { //正常列
//	                    System.out.println(col.getExpr().toString());
//	                }
//	            }
//	        } else {
//	           // log.error(sqlparser.getErrormessage());
//	        }
//	}
}
