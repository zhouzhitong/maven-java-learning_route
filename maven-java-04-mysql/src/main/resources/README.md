


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





