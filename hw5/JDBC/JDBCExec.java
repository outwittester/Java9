
package com.example.demo;

import java.sql.*;
import java.util.*;

public class JDBCExec {
//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/employees?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
////    jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
//
//    //  Database credentials
//
//    static final String USER = "root";
//    static final String PASS = "20030242zhang";

    public static void main(String[] args){
        JDBCUtil jdbcUtil = new JDBCUtil("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false&" +
                        "useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                "root", "20030242zhang");
        String sql = "select * from employees where emp_no = 10004";
        System.out.println(jdbcUtil.executeQuery(sql, null));

    }
}
