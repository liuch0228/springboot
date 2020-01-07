### springboot整合mybatis
##### JDBC访问数据库
1. 加载msyql驱动：Class.forName("com.mysql.jdbc.driver)
2. 建立连接 DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname,"root","root")
3. 创建statement
4. 执行sql语句
5. 处理ResultSet结果集
6. 关闭连接，释放资源
##### springboot整合Mybatis3.x

##### mysql事务隔离级别和传播机制
1. 数据库事务，常见的隔离级别和传播行为
2. 分布式事务：二阶提交 ，最终一致性，通过消息队列来解决
3. 事务的隔离级别
   		Serializable： 最严格，串行处理，消耗资源大
   		Repeatable Read：保证了一个事务不会修改已经由另一个事务读取但未提交（回滚）的数据
   		Read Committed：大多数主流数据库的默认事务等级
   		Read Uncommitted：保证了读取过程中不会读取到非法数据。
   
   事务的传播行为
   		PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务,最常见的选择。
   		PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
   		PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
   		PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起, 两个事务之间没有关系，一个异常，一个提交，不会同时回滚
   		PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
   		PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常
 
REQUIRES_NEW 要写在service里面然后该方法被调用，才会起作用，同一个service中只会起一个事务

#### springboot整合redis
##### 1.添加依赖
```     
<dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
##### 2.配置文件
```
#redis配置
spring.redis.database=0
spring.redis.host=192.168.5.106
spring.redis.port=8007
#超时时间，单位ms
spring.redis.timeout=3000
# redis连接池中最大空闲连接，默认是8
spring.redis.jedis.pool.max-idle=8
# -1表示不限制；连接池可分配的最大的jedis实例个数，实例个数达到该配置值时，连接池状态为exhausted
spring.redis.jedis.pool.max-active=8
#等待可用连接的最大时间，单位ms,默认-1 表示永不超时
spring.redis.jedis.pool.max-wait=1000
```
#### 3.使用



