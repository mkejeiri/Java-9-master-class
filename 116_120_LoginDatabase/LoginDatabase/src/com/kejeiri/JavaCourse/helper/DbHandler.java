package com.kejeiri.JavaCourse.helper;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection(){
        String connectionString = "jdbc:mysql://"+dbHost+"/"+dbName+"?user="+dbUser+"&password="+
                dbPass+"&useSSL=false&useUnicode=true&"+
                "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                dbConnection = DriverManager.getConnection(connectionString);
                System.out.println("Connected to DB: "+dbConnection.getCatalog());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }











        return dbConnection;
    }





}
