//准备mysql的环境：
create table rs_user(
id int,
name varchar(20),
email varchar(18)
)
//准备oracle的环境
create table rs_user(
id number,
name varchar2(20),
email varchar2(18)
)
insert into rs_user(id,name,email) values(1,'张三','xx@gmail.com');
insert into rs_user(id,name,email) values(2,'李四','tt@gmail.com');
insert into rs_user(id,name,email) values(3,'王五','qq@gmail.com');
insert into rs_user(id,name,email) values(5,'赵六','mm@gmail.com');
