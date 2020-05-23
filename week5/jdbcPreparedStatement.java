package com.example.demo.controller;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class jdbcPreparedStatement {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/baanyan?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
//    jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "yourpassword";


    //read
    public void read(int number){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = connection.createStatement();
//            String sql = "select * from tb_user where id=" + number;
//            ResultSet rs = statement.executeQuery(sql);

            PreparedStatement preparedStat = connection.prepareStatement("select * from tb_user where id=?");
            preparedStat.setInt(1, number);
            ResultSet rs = preparedStat.executeQuery();


            while (rs.next()) {
                System.out.println(
                                rs.getInt("id") + " " +
                                rs.getString("username") + " " +
                                rs.getString("password") + " " +
                                rs.getString("phone") + " " +
                                rs.getString("created") + " " +
                                rs.getString("salt"));

                //get all data in the first column
//                System.out.println(rs.getInt(1));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("out read");
            e.printStackTrace();
        }
    }

    //update
    public static void insert(int id, String username, String password, String phone, Date created, String salt){
        String sql = "INSERT INTO `tb_user`\n" +
                "(`id`,\n" +
                "`username`,\n" +
                "`password`,\n" +
                "`phone`,\n" +
                "`created`,\n" +
                "`salt`)\n" +
                "VALUES\n" +
                "(? ,\n ? ,\n ? ,\n ? ,\n ? ,\n ?);";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStat = connection.prepareStatement(sql);
            preparedStat.setInt(1, id);
            preparedStat.setString(2, username);
            preparedStat.setString(3, password);
            preparedStat.setString(4, phone);

            preparedStat.setDate(5, new java.sql.Date(created.getTime()));
            preparedStat.setString(6, salt);

            if(!existId(id)){
                preparedStat.executeUpdate();
            }
            else{
                System.out.println("Insertion failed due to ID exists!");
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("out insert");
            e.printStackTrace();
        }
    }

    private static boolean existId(int number){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStat = connection.prepareStatement("select * from tb_user where id=?");
            preparedStat.setInt(1, number);
            //System.out.println("existId " + number);
            ResultSet rs = preparedStat.executeQuery();

            rs.next();
            int n = rs.getInt("id");
            //System.out.println("after rs " + n);

            connection.close();
            if(n != number){
                return false;
            }

        } catch (SQLException e) {
            System.out.println("out existId");
            e.printStackTrace();
        }
        return true;
    }

    //updateAll
    public static void updateAll(List<User> list){

        String sql =
                "INSERT INTO `tb_user`\n" +
                        "(`id`,\n" +
                        "`username`,\n" +
                        "`password`,\n" +
                        "`phone`,\n" +
                        "`created`,\n" +
                        "`salt`)\n" +
                        "VALUES\n" +
                        "( ?,\n ?,\n ?,\n ?,\n ?,\n ?);";

        try {

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStat = connection.prepareStatement(sql);

            Iterator<User> it = list.iterator();

            while(it.hasNext()){
                User element = it.next();
                preparedStat.setInt(1, element.getId());
                preparedStat.setString(2, element.getUsername());
                preparedStat.setString(3, element.getPassword());
                preparedStat.setString(4, element.getPhone());
                preparedStat.setDate(5, new java.sql.Date(element.getCreated().getTime()));
                preparedStat.setString(6, element.getSalt());

                System.out.println(element.getId());

                if(existId(element.getId())){
                    jdbcPreparedStatement jd = new jdbcPreparedStatement();
                    jd.delete(element.getId());
                    //System.out.println("exist");
                    preparedStat.executeUpdate();
                }
                else{
                    preparedStat.executeUpdate();
                }
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("out updateAll");
            e.printStackTrace();
        }
    }


    //delete
    public void delete(int number){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();

            //System.out.println("delete " + number);
            String sql = "delete from tb_user where id = " + number;
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException e) {
            System.out.println("out delete");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        jdbcPreparedStatement jd = new jdbcPreparedStatement();
        jd.read(55);

        //jd.delete(77);

        Date d = new Date();
        jdbcPreparedStatement updateSingle = new jdbcPreparedStatement();
        updateSingle.insert(77,"Hello", "123", "4567891234", d, "fsghjkwwety");

        User user1 = new User();
        user1.setId(12);
        user1.setUsername("abc");
        user1.setPassword("abc123");
        user1.setPhone("424445555");
        Date day1 = new Date();
        user1.setCreated(day1);
        user1.setSalt("fsfgqrergwe");

        User user2 = new User();
        user2.setId(15);
        user2.setUsername("ccc");
        user2.setPassword("abc123");
        user2.setPhone("424446666");
        Date day2 = new Date();
        user2.setCreated(day2);
        user2.setSalt("fsfgqssdsdsrergwe");


        List<User> list = new LinkedList<>();
        list.add(user1);
        list.add(user2);
        jdbcPreparedStatement all = new jdbcPreparedStatement();
        all.updateAll(list);

        jd.read(12);
        jd.read(15);
    }
}
