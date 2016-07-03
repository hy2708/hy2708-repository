 #账户基本信息表
 create table account
 (
    accountid   varchar(18) ,  #账号
    balance     double(10,2)   #余额
 )
#存款表
 create table inaccount
(
	accountid   varchar(18) ,  #账号
 	inbalance     double(10,2) #存入余额
 )
 #办卡完成，初始化数据
INSERT INTO account(accountid,balance) VALUES('123456789',0)
 