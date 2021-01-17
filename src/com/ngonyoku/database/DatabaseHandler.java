package com.ngonyoku.database;

import com.ngonyoku.model.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            PreparedStatement statement = getDatabaseConnection().prepareStatement(insertSQL);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getLocation());
            statement.setString(6, user.getGender());

            int rowCount = statement.executeUpdate();

            System.out.println(rowCount + " rows Affected!");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
