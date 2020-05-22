package com.example.demo;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import java.sql.*;
import java.util.*;

//reference: https://blog.csdn.net/weixin_38303684/article/details/78263008
public class JDBCUtil {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    private CallableStatement callableStatement = null;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet result = null;

    public JDBCUtil(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Establish Database Connection
     */
    public Connection getConnection() {
        try {
            try{
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.out.println("Driver loading error");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    //return number of rows affected;
    public int executeUpdate(String sql, Object[] params) {
        int affectedLine = 0;
        try {
            connection = this.getConnection();
            pst = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; ++i) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            affectedLine = pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return affectedLine;
    }

    private ResultSet executeQueryRS(String sql, Object[] params) {
        try {
            connection = this.getConnection();
            pst = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            //execute query
            result = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Object executeQuerySingle(String sql, Object[] params) {
        Object object = null;
        try {
            connection = this.getConnection();
            pst = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            result = pst.executeQuery();
            if (result.next()) {
                object = result.getObject(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return object;
    }
    public List<Object> executeQuery(String sql, Object[] params) {
        ResultSet resultset = executeQueryRS(sql, params);
        ResultSetMetaData meta = null;
        int columnCount = 0;
        try {
            meta = resultset.getMetaData();
            columnCount = meta.getColumnCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        List<Object> list = new ArrayList<Object>();

        try {
            //save resultset to List
            while (resultset.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(meta.getColumnLabel(i), resultset.getObject(i));
                }
                list.add(map);//save map into list
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return list;
    }

    private void closeAll() {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (callableStatement != null) {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



