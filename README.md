# arthas-sql-demo
arthas sql profiler demo

该demo是为了验证arthas的splprofiler功能，执行步骤：

1. 由于该项目demo使用的h2内存数据库，项目直接编译运行即可。

2. 启动arthas连接到当前进程，然后执行arthas命令, 可以看到类似如下输出：
```bash
[arthas@18731]$ sqlprofiler
Press Q or Ctrl+C to abort.
Affect(class count: 11 , method count: 586) cost in 328 ms, listenerId: 1
ts=2021-08-16 17:19:12; [method=org.h2.jdbc.JdbcStatement.executeQuery] [cost=0.847917ms]
sql: select * from org_user
args: 
ts=2021-08-16 17:19:12; [method=com.zaxxer.hikari.pool.ProxyStatement.executeQuery] [cost=2.62625ms]
sql: select * from org_user
args: 
ts=2021-08-16 17:19:12; [method=com.zaxxer.hikari.pool.HikariProxyStatement.executeQuery] [cost=4.020417ms]
sql: select * from org_user
args: 
ts=2021-08-16 17:19:12; [method=org.h2.jdbc.JdbcPreparedStatement.executeQuery] [cost=0.414959ms]
sql: select * from org_user where age <= ?
args: 18
ts=2021-08-16 17:19:12; [method=com.zaxxer.hikari.pool.ProxyPreparedStatement.executeQuery] [cost=1.233208ms]
sql: select * from org_user where age <= ?
args: 18
ts=2021-08-16 17:19:12; [method=org.h2.jdbc.JdbcPreparedStatement.executeUpdate] [cost=1.15275ms]
sql: update org_user set age = age + ?
args: 1
ts=2021-08-16 17:19:12; [method=com.zaxxer.hikari.pool.ProxyPreparedStatement.executeUpdate] [cost=2.619542ms]
sql: update org_user set age = age + ?
args: 1

```
