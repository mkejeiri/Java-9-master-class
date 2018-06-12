package sample.database;

import sample.controller.Controller;
import sample.model.Task;
import sample.model.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

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
                System.out.println("Status: Connected to "+dbConnection.getCatalog());
            } catch (SQLException e) {
                System.out.println("Status: Connection error!");
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



    public void signUp(User user) {

        String SQL_INSERT = "INSERT INTO "+Const.USERS_TABLE+"("
                            +Const.USERS_FIRSTNAME+" ,"
                            +Const.USERS_LASTNAME+" ,"
                            +Const.USERS_USERNAME+" ,"
                            +Const.USERS_PASS+" ,"
                            +Const.USERS_LOC+" ,"
                            +Const.USERS_GENDER+") VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getLocation());
            preparedStatement.setString(6,user.getGender());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ResultSet getUser(User user){
        ResultSet resultSet=null;
        if (!user.getUserName().equals("") || !user.getPassword().equals("")){
            String SQL_SELECT = "SELECT * FROM "+ Const.USERS_TABLE + " WHERE "
                    +Const.USERS_USERNAME + " = ? AND "
                    + Const.USERS_PASS + " = ? ";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = getDbConnection().prepareStatement(SQL_SELECT);
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getPassword());
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Please enter your credentials");
        }

        return resultSet;
    }

    public boolean isUserLoggedIn(User user){
        try {
            return getUser(user).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void InsertTask(Task task) {

        String SQL_INSERT = "INSERT INTO "+Const.TASKS_TABLE+"("
                +Const.TASKS_USERID+" ,"
                +Const.TASKS_TASK+" ,"
                +Const.TASKS_DESC+" ,"
                +Const.TASKS_DATECREATED+") VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1,task.getUserId());
            preparedStatement.setString(2,task.getTask());
            preparedStatement.setString(3,task.getDescription());
            preparedStatement.setTimestamp(4,new Timestamp(task.getDateCreated().getTime()));
            //preparedStatement.setLong(4,task.getDateCreated());
            System.out.println("Task inserted");

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllTasksByUserId(int userId){
        String SQL_SELECT = "SELECT * FROM "+ Const.TASKS_TABLE + " WHERE "
                +Const.TASKS_USERID + " = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            preparedStatement = getDbConnection().prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public int getTotalTasks(int userId) throws SQLException {
        int taskNumber = 0;
        String SQL_SELECT = "SELECT COUNT(*) FROM "+ Const.TASKS_TABLE + " WHERE "
                +Const.TASKS_USERID + " = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
            preparedStatement = getDbConnection().prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                taskNumber=resultSet.getInt(1);
            }
        return taskNumber;
    }


    public void deleteTask(int taskId) {

        String SQL_DELETE = "DELETE FROM "+Const.TASKS_TABLE
                + " WHERE "+Const.TASKS_TASKID + " = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1,taskId);
            preparedStatement.execute();
            System.out.println("Taskid "+taskId+" DELETED" );
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateTask(Task task) {
        String SQL_DELETE = "UPDATE "+Const.TASKS_TABLE
                + " SET "+Const.TASKS_TASK +" =? ," + Const.TASKS_DESC +" =? "
                + " WHERE "+Const.TASKS_TASKID + " = ?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setString(1,task.getTask());
            preparedStatement.setString(2,task.getDescription());
            preparedStatement.setInt(3,task.getTaskId());

            preparedStatement.execute();
            System.out.println("Taskid "+task.getTaskId()+" Updated" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
