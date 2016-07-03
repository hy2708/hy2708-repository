CREATE TABLE person(
  id INT PRIMARY KEY,
  NAME VARCHAR(30)
);
CREATE TABLE cars(
  id INT PRIMARY KEY,
  NAME VARCHAR(30),
  price NUMERIC(5,2),
  pid INT
);
ALTER TABLE cars
   ADD CONSTRAINT c_fk FOREIGN KEY(pid) REFERENCES person(id);
   
   
   INSERT INTO person VALUES(1,'Jack');
INSERT INTO person VALUES(2,'Tom');
INSERT INTO person VALUES(3,'Rose');

INSERT INTO cars VALUES(11,'BWM',89,1);
INSERT INTO cars VALUES(12,'Beaz',77,1);
INSERT INTO cars VALUES(13,'QQ',4,3);


INSERT INTO person VALUES(1,'Jack');
INSERT INTO person VALUES(2,'Tom');
INSERT INTO person VALUES(3,'Rose');

INSERT INTO cars VALUES(11,'BWM',89,1);
INSERT INTO cars VALUES(12,'Beaz',77,1);
INSERT INTO cars VALUES(13,'QQ',4,3);
INSERT INTO cars VALUES(14,'Cheay',7,NULL);


SELECT p.name,c.name
FROM person p INNER JOIN cars c ON p.id=c.pid;

/*外关系-左，右*/
SELECT p.name,c.name
FROM person p RIGHT outer JOIN cars c ON p.id=c.pid; 

/*查询没有车人*/
SELECT p.name,c.name 
FROM person p LEFT outer JOIN cars c ON p.id=c.pid
WHERE c.name IS NULL;

SELECT * FROM cars WHERE pid IS NULL;


/*查询有两个车的人*/
SELECT * FROM 
person p WHERE (SELECT COUNT(*) FROM cars c WHERE p.id=c.pid)=1;
/*每个人的汽车数量*/
SELECT pid, COUNT(pid) FROM cars c GROUP BY pid;

SELECT * FROM 
person p INNER JOIN (SELECT pid, COUNT(pid) AS count_of_cars FROM cars c GROUP BY pid) AS c2 ON (p.id= c2.pid);

SELECT * FROM 
person p INNER JOIN (SELECT pid, COUNT(pid) AS count_of_cars FROM cars c GROUP BY pid HAVING count_of_cars=2) AS c2 ON (p.id= c2.pid);

CREATE TABLE card(
  id INT PRIMARY KEY,
  gov VARCHAR(30),
  CONSTRAINT card_fk FOREIGN KEY(id) REFERENCES person(id)
)

INSERT INTO card VALUES(3,'北京公安局');

SELECT p.name,c.gov
FROM person p INNER JOIN card c ON p.id=c.id;
