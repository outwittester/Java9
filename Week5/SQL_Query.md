# SQL Query


## Aggregate function
Aggregate functions are used to perform operations across entire columns. An aggregate function performs a calculation one or more values and returns a single value. The aggregate function is often used with the GROUP BY clause and HAVING clause of the SELECT statement.

COUNT counts how many rows are in a particular column.
SUM adds together all the values in a particular column.
MIN and MAX return the lowest and highest values in a particular column, respectively.
AVG calculates the average of a group of selected values.


## View
A view is a virtual table based on the result set of an SQL statement. A View can either have all the rows of a table or specific rows based on certain condition.
The CREATE VIEW command creates a view.

(views exist only for a single query, and each time you generate a view it is recreated from current data. In contrast, a temp table exists for the entire database session, and once populated it retains those records until the session ends.)


## Left Join
The LEFT JOIN keyword returns all records from the left table (table1), and the matched records from the right table (table2). The result is NULL from the right side, if there is no match.


## Truncate
The SQL TRUNCATE TABLE command is used to delete complete data from an existing table.
TRUNCATE statement is a Data Definition Language (DDL) operation that is used to mark the extents of a table for deallocation (empty for reuse). The result of this operation quickly removes all data from a table,

(DELETE is a DML command. The DELETE command is used to remove rows from a table based on WHERE condition. It maintains the log, so it slower than TRUNCATE. elete uses more transaction space than the Truncate statement. We can ROLLBACK a delete query but not so for truncate and drop.)

(You can also use DROP TABLE command to delete complete table but it would remove complete table structure form the database and you would need to re-create this table once again if you wish you store some data.)


## Procedure
A procedure (often called a stored procedure) is a subroutine like a subprogram in a regular computing language, stored in database. A subprogram is a program unit/module that performs a particular task.

It is created with the CREATE PROCEDURE or the CREATE FUNCTION statement. It is stored in the database and can be deleted with the DROP PROCEDURE or DROP FUNCTION statement.


## Pagination
pagination is where you divide the query results into smaller chunks, each chunk continuing where the previous finished. Pagination refers to reducing the number of records from a structured query language query result sets. For instance, most database platforms implements SQL result set pagination by using the OFFSET/FETCH and LIMIT clauses.