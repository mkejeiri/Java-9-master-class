package com.kejeiri.JavaCourse;

/*import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/

import com.kejeiri.JavaCourse.helper.DbHandler;
import java.sql.*;

public class LoginDatabase {
    private static DbHandler dbHandler;
    private static Connection connection;
    private static PreparedStatement preparedStatement;


    public static void main(String[] args) {
        insertData();
        getData();
        updateData("John","Doe","jdoe","West virginia",20,1);
        deleteData(7);

       /*try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Connection conn = null;
            try {
                conn =
                        DriverManager.getConnection("jdbc:mysql://localhost/Login?" +
                                "user=appUser&password=[UR_PASSWORD]&useSSL=false&useUnicode=true&"+
                                "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                System.out.println("Connected to DB: "+conn.getCatalog());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    private static void insertData() {
        dbHandler = new DbHandler();
        connection = dbHandler.getDbConnection();
        String insertQuery ="INSERT INTO `Login`.`users` (`firstname`,`lastname`,`username`,`address`,`age`)VALUES(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,"xxx");
            preparedStatement.setString(2,"xx");
            preparedStatement.setString(3,"xxx");
            preparedStatement.setString(4,"Avenue des croix de l'yser, 30 bruxelles");
            preparedStatement.setInt(5,29);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData(String firstname, String lastname, String username, String address, int age, int id) {
        dbHandler = new DbHandler();
        connection = dbHandler.getDbConnection();
        String updateQuery ="UPDATE `Login`.`users` SET `firstname` = ?, `lastname` = ?,"+
                            "`username` = ?, `address` = ?, `age` = ? WHERE `userId` = ?";
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,address);
            preparedStatement.setInt(5,age);
            preparedStatement.setInt(6,id);
            int update =  preparedStatement.executeUpdate();
            System.out.println("Update : " +update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData(int id) {
        dbHandler = new DbHandler();
        connection = dbHandler.getDbConnection();
        String DeleteQuery ="DELETE FROM `users` WHERE `userId` = ?";
        try {
            preparedStatement = connection.prepareStatement(DeleteQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void getData() {
        dbHandler = new DbHandler();
        connection = dbHandler.getDbConnection();
        String selectQuery ="SELECT `userId`,`firstname`,`lastname`,`username`,`address`,`age` FROM `users`";
        try {
            preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("User Name: " + resultSet.getString("firstname") + ", "
                        + resultSet.getString("lastname") + ", "
                        + resultSet.getString("address") + ", "
                        + resultSet.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
