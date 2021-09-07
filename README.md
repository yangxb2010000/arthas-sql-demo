# arthas-sql-demo
arthas sql profiler demo

该demo是为了验证arthas的splprofiler功能，执行步骤：

1. 由于该项目demo使用的h2内存数据库，项目直接编译运行即可。

2. 启动arthas连接到当前进程，然后执行arthas命令, 可以看到类似如下输出：
```bash
[arthas@63033]$ sqlprofiler
Press Q or Ctrl+C to abort.
Affect(class count: 11 , method count: 586) cost in 362 ms, listenerId: 1
ts=2021-09-07 14:54:34; [method=com.zaxxer.hikari.pool.HikariProxyStatement.executeQuery] [cost=1.777583ms]
sql: select * from org_user
args: 
ts=2021-09-07 14:54:34; [method=com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeQuery] [cost=1.08075ms]
sql: select * from org_user where age <= ?
args: 18
ts=2021-09-07 14:54:34; [method=com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeUpdate] [cost=1.149708ms]
sql: update org_user set age = age + ?
args: 1
ts=2021-09-07 14:54:34; [method=com.zaxxer.hikari.pool.HikariProxyStatement.executeBatch] [cost=2.386958ms]
sql: update org_user set age = age + 1;update org_user set age = age - 1
args: 
ts=2021-09-07 14:54:34; [method=com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeBatch] [cost=1.894625ms]
sql: update org_user set age = age + ?
args: 
--(10)
--(20)

```
