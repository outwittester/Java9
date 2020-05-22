import java.sql.*;

public class MyJDBCTest {
    public static void main(String[] args) {
        MyJDBC instance = MyJDBC.getInstance();
        String sql1 = "INSERT INTO employees VALUES (000001, '2020-05-22', 'ABC', 'XYZ', 'F', '2020-05-22')";
        String sql2 = "DELETE FROM employees WHERE emp_no = 10004";
        String sql3 = "UPDATE employees SET first_name = 'update' WHERE emp_no = 10002";
        String sql4 = "SELECT * FROM employees LIMIT 6";

        try{
            instance.myExecuteInsert(sql1);
            instance.myExecuteDelete(sql2);
            instance.myExecuteUpdate(sql3);
            ResultSet rs = instance.myExecuteQuery(sql4);

            // get meta data of the table
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnNumber = rsmd.getColumnCount();

            // print table head
            for (int i = 1; i <= columnNumber; i++) {
                System.out.print("\t" + rsmd.getColumnName(i));
            }
            System.out.println();

            // print the whole table row by row
            while(rs.next()) {
                for (int i = 1; i <= columnNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print("\t" + columnValue);
                }
                System.out.println();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        instance.closeConnection();

    }
}

class MyJDBC {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "****";

    private static Connection connection;
    private static Statement statement;
    private static final MyJDBC instance = new MyJDBC();

    // constructor
    private MyJDBC() {
        try {
            Class clazz = Class.forName(JDBC_DRIVER); //This step causes the JVM to load the desired driver implementation into memory so it can fulfill your JDBC requests.
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
            this.statement = connection.createStatement();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Get instance
    public static MyJDBC getInstance() {
        return instance;
    }

    // Close connection
    public void closeConnection() {
        try {
            if (this.statement != null) this.statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (this.connection != null) this.connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查
    public ResultSet myExecuteQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 改
    public int myExecuteUpdate(String sql) {
        int numRows = 0;
        try {
            numRows = this.statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return numRows;
    }

    // 增
    public int myExecuteInsert(String sql) {
        int numRows = 0;
        try {
            numRows = this.statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return numRows;
    }

    // 删
    public int myExecuteDelete(String sql) {
        int numRows = 0;
        try {
            numRows = this.statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return numRows;
    }

}