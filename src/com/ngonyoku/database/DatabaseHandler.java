package com.ngonyoku.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection databaseConnection;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String databaseUrl = "jdbc:mysql//" + databaseHost + ":" + databasePort + "/" + databaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseConnection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

        return databaseConnection;
    }
}
