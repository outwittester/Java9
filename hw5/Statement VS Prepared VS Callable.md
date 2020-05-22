Statement:
* Statement is used for general purpose access to the database. It is used as static statements at runtime. The Statement Interface cannot accept parameters. It is slow because it compiles the program for each execution

Prepared Statment:
* We use prepared statment when we plan to use SQL statments many times. The PreparedStatement interface accepts input parameters at runtime. we can use ? symbol in sql command so setting dynamic value is simple.

CallableStatment: 
* We use this when we want to access the database stored procedures. The CallableStatement interface can also accept runtime input parameters.