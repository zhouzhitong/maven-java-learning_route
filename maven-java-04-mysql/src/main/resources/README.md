
## 事务

```sql
--查看是否是自动提交 1表示开启，0表示关闭
select @@autocommit;
--设置关闭
set autocommit = 0;
-- commit     提交事务
-- rollback   回滚实体
-- savePoint  保存当前节点状态

--事务包含四个隔离级别：从上往下，隔离级别越来越高，意味着数据越来越安全
read uncommitted; 	--读未提交
read commited;		--读已提交
repeatable read;	--可重复读
(seariable)			--序列化执行，串行执行
--产生数据不一致的情况：
脏读
不可重复读
幻读

```

- **案例**
```sql
--创建数据库
create database tran;
--切换数据库 两个窗口都执行
use tran;
--准备数据
 create table psn(id int primary key,name varchar(10)) engine=innodb;
--插入数据
insert into psn values(1,'zhangsan');
insert into psn values(2,'lisi');
insert into psn values(3,'wangwu');
commit;
```

| 隔离级别 | 异常情况 |            | 异常情况 |
| -------- | -------- | ---------- | -------- |
| 读未提交 | 脏读     | 不可重复读 | 幻读     |
| 读已提交 |          | 不可重复读 | 幻读     |
| 可重复读 |          |            | 幻读     |
| 序列化   |          |            |          |

- 测试1：脏读 read uncommitted

```sql
set session transaction isolation level read uncommitted;
A:start transaction;
A:select * from psn;
B:start transaction;
B:select * from psn;
A:update psn set name='msb';
A:selecet * from psn
B:select * from psn;  --读取的结果msb。产生脏读，因为A事务并没有commit，读取到了不存在的数据
A:commit;
B:select * from psn; --读取的数据是msb,因为A事务已经commit，数据永久的被修改
```

- 测试2：当使用read committed的时候，就不会出现脏读的情况了，当时会出现不可重复读的问题

```sql
set session transaction isolation level read committed;
A:start transaction;
A:select * from psn;
B:start transaction;
B:select * from psn;
--执行到此处的时候发现，两个窗口读取的数据是一致的
A:update psn set name ='zhangsan' where id = 1;
A:select * from psn;
B:select * from psn;
--执行到此处发现两个窗口读取的数据不一致，B窗口中读取不到更新的数据
A:commit;
A:select * from psn;--读取到更新的数据
B:select * from psn;--也读取到更新的数据
--发现同一个事务中多次读取数据出现不一致的情况
```

- 测试3：当使用repeatable read的时候(按照上面的步骤操作)，就不会出现不可重复读的问题，但是会出现幻读的问题

```sql
set session transaction isolation level repeatable read;
A:start transaction;
A:select * from psn;
B:start transaction;
B:select * from psn;
--此时两个窗口读取的数据是一致的
A:insert into psn values(4,'sisi');
A:commit;
A:select * from psn;--读取到添加的数据
B:select * from psn;--读取不到添加的数据
B:insert into psn values(4,'sisi');--报错，无法插入数据
--此时发现读取不到数据，但是在插入的时候不允许插入，出现了幻读，设置更高级别的隔离级别即可解决
```

- 总结：
> 现在学习的是数据库级别的事务，需要掌握的就是事务的隔离级别和产生的数据不一致的情况
> 后续会学习声明式事务及事务的传播特性以及分布式事务


## 连接池：

### 1. Druid：[https://github.com/alibaba/druid/wiki](https://github.com/alibaba/druid/wiki)
### 2. HikariCP：[https://github.com/brettwooldridge/HikariCP](https://github.com/brettwooldridge/HikariCP)



# 索引

## 1.1 索引分类：

```markdown
- 1. 聚簇索引：数据和文件放在一起（innodb）
- 2. 非聚簇索引：数据和索引单独放在一个文件中（MylSAM）
```



### 1.1.1 聚簇索引

> `.frm`：存放表结构
>
> `.ibd`：存放数据文件和索引文件



==注意== ：**mysql** 的**innodb** 存储引擎默认情况下会把所有的数据文件放在表到表空间中，
不会为每一个单独的表保存一份数据文件。

如果需要将每一个表单独使用文件保存，设置如下属性：

```shell
- set global innodb_file_per_table = on;
```



### 1.1.2 非聚簇索引

> `.frm`：表结构
>
> `.MYD`：实际数据
>
> `.MYI`：索引





### 1.1.3 索引区别





## 1.2 索引结构：



> - Hash
> - 二叉树
> - B树
> - B+树





