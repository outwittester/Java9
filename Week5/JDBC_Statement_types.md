# JDBC Statement Compare

## Statement

Use this for general-purpose access to your database. Useful when you are using static SQL statements at runtime. The Statement interface cannot accept parameters.

## PreparedStatement

Use this when you plan to use the SQL statements many times. The PreparedStatement interface accepts input parameters at runtime.

## CallableStatement

Use this when you want to access the database stored procedures. The CallableStatement interface can also accept runtime input parameters.

## Compare performance

Statement interface is used to execute normal SQL queries. You can’t pass the parameters to SQL query at run time using this interface. This interface is preferred over other two interfaces if you are executing a particular SQL query only once.

It is recommended to use PreparedStatement if you are executing a particular SQL query multiple times. It gives better performance than Statement interface. Because, PreparedStatement are precompiled and the query plan is created only once irrespective of how many times you are executing that query. This will save lots of time.

CallableStatement extends PreparedStatement. The performance of this interface is higher than the other two interfaces. Because, it calls the stored procedures which are already compiled and stored in the database server.