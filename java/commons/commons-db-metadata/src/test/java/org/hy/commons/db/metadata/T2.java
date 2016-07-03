package org.hy.commons.db.metadata;

import org.hy.commons.example.entity.Classroom;
import org.hy.commons.example.entity.Course;
import org.hy.commons.example.entity.Student;

import jodd.db.oom.DbOomManager;
import jodd.db.oom.naming.TableNamingStrategy;
import jodd.db.oom.sqlgen.DbSqlBuilder;


public class T2 {

	public static void main(String[] args) {
		DbSqlBuilder builder 
		=new DbSqlBuilder();
		User user= new User();
		user.setId(1);
		user.setPassword("ppp");
		DbOomManager dbOomManager =DbOomManager.getInstance();
		TableNamingStrategy tableNamingStrategy = new TableNamingStrategy();
		tableNamingStrategy.setPrefix("t_");
		dbOomManager.setTableNames(tableNamingStrategy);
		dbOomManager.registerEntity(User.class);
		dbOomManager.registerEntity(Student.class);
		dbOomManager.registerEntity(Classroom.class);
		dbOomManager.registerEntity(Course.class);
		System.err.println(builder.sql("select $C{g} form $T{User g}").generateQuery().toString());;
		System.err.println(builder.sql("select $C{u.password} form $T{User u}").generateQuery().toString());;
		System.err.println(builder.sql("select $C{u.+} form $T{User u}").generateQuery().toString());;
		System.err.println(builder.sql("select $C{u.password} form $T{User u} where $u.id=1").generateQuery().toString());;
		System.err.println(builder.sql("select $C{u.password} form $T{User u} where  $M{u=boy}").use("boy", user).generateQuery().toString());
		System.err.println(builder.sql("select $C{t.*}, $C{tp.*}, $C{c.*} " +
						              "from $T{Student t} join $T{Classroom tp} using ($.telecomId) " +
						              "join $T{Course c} using ($.countryId)").generateQuery());
		
	}
}
