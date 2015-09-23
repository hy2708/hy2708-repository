/*模糊查询*/
SELECT * FROM hib3_test.t_stu t where name like '%人%';
/*范围查询*/
SELECT * FROM hib3_test.t_stu t where cla_id in (1,2);
/*区间查询*/
SELECT born FROM hib3_test.t_stu t where born between '1980-01-01' and '1988-01-01';
/*查询年龄*/
SELECT  year(now())-Year(born) as 'age', 
Year(born) as 'birthYear' FROM hib3_test.t_stu t ;

SELECT  year(now())-Year(born) as 'age', Year(born) as 'birthYear' FROM hib3_test.t_stu t where year(now())-Year(born) <29
or year(now())-Year(born) >40;
/*查询最小年龄*/
SELECT  min(born) FROM hib3_test.t_stu ;
/*查询年龄最小的人*/
SELECT id, name,sex ,born,max(born) FROM hib3_test.t_stu where born=(select max(born)from  hib3_test.t_stu );
/*查询，在3班中，年龄最小的人*/
SELECT id, name,sex ,born,cla_id FROM hib3_test.t_stu where  born=(select max(born)from  hib3_test.t_stu where cla_id=3)
and cla_id=3;
/*查询班级为空的*/
SELECT * FROM hib3_test.t_stu t where cla_id is  null;
/*查询班级人数*/
SELECT count(*) as 'renshu' FROM hib3_test.t_stu ;
SELECT count(*) as 'renshu' FROM hib3_test.t_stu where cla_id = 2;
/*分组查询*/

/*这是错误的*/
SELECT cla_id ,max(born) FROM hib3_test.t_stu group by cla_id where cla_id is not null ;
/*这是正确的*/
SELECT cla_id ,max(born) FROM hib3_test.t_stu where cla_id is not null group by cla_id ;
/*为分组添加条件
 * 查询的条件，是在查询出来的投影中的时候，不用where，用having
 * */
SELECT cla_id ,max(born),count(*) as 'renshu' FROM hib3_test.t_stu where cla_id is not null
 group by cla_id having renshu >60 ;
/*男女的人数*/
 SELECT cla_id ,max(born),count(*) as 'renshu' FROM hib3_test.t_stu group by sex  ;
/*各个班的那女人数*/
 SELECT cla_id ,max(born),count(*),sex as 'renshu' FROM hib3_test.t_stu where cla_id is not null group by sex,cla_id order by cla_id ;
/*不同年份出生的人数*/
SELECT count(*),year(born) FROM hib3_test.t_stu group by YEAR(born);



