import java.sql.*;
public class MyJDBC {
    public static void main(String[] args) {
        JDBCUtil i = JDBCUtil.getInstance();
        i.connect();
        try{
            ResultSet rs = i.select("*", "emp_no < 10010", "employees");
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }
}
class JDBCUtil{
    private static JDBCUtil instance;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/employees?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "940508";

    private static Connection connection = null;
    private static Statement statement = null;

    private JDBCUtil() {
//        this.driver = driver;
//        this.url = url;
//        this.username = username;
//        this.password = password;
    }
    public static synchronized JDBCUtil getInstance(){
        if(instance == null){
            instance = new JDBCUtil();
        }
        return instance;
    }
    public void connect(){


        try{
            Class clazz = Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }
        //return connection;
    }
    public void close(){
        try{
            if (connection != null)
                connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet execute(String s){
        ResultSet r = null;
        try{
            r = statement.executeQuery(s);
        }
        catch(SQLException e){
            System.out.println("eee");
        }
        return r;
    }

    public ResultSet insert(String value, String table){
        String q = "INSERT INTO " + table + " VALUES " + value;
        return execute(q);

    }
    public ResultSet delete(String condition, String table){
        String q = "DELETE FROM " + table + " WHERE " + condition;
        return execute(q);
    }
    public ResultSet select(String rolls, String condition, String table){
        String q = "SELECT " + rolls + " FROM " + table + " WHERE " + condition;
        return execute(q);
    }
    public ResultSet update(String value, String condition, String table){
        String q = "UPDATE " + table + " SET " + value + " WHERE " + condition;
        return execute(q);
    }





}
