package com.ngonyoku.database;

import com.ngonyoku.model.Users;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection databaseConnection;

    //The method establishes a database connection
    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String databaseUrl = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseConnection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

        return databaseConnection;
    }

    public void signUpUser(Users user) {
        String insertSQL = "INSERT INTO " + Const.USERS_TABLE +
                "(" + Const.USERS_FIRST_NAME +
                "," + Const.USERS_LAST_NAME +
                "," + Const.USERS_USERNAME +
                "," + Const.USERS_PASSWORD +
                "," + Const.USERS_LOCATION +
                "," + Const.USERS_GENDER +
                ") VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = getDatabaseConnection().prepareStatement(insertSQL);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getLocation());
            stmt.setString(6, user.getGender());

            int rowCount = stmt.executeUpdate();

            System.out.println(rowCount + " rows Affected!");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getUser(Users user) {
        ResultSet rs = null;
        if (!user.getUsername().equals("") || !user.getPassword().equals("")) {
            //Check if the record exists
            String query = "SELECT * FROM " + Const.USERS_TABLE +
                    " WHERE " + Const.USERS_USERNAME + " = ?" +
                    " AND " + Const.USERS_PASSWORD + " = ?" +
                    ";";


            try {
                PreparedStatement stmt = getDatabaseConnection().prepareStatement(query);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());

                rs = stmt.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please Enter your credentials");
        }
        return rs;
    }
}
