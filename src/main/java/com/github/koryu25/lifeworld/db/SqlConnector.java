package com.github.koryu25.lifeworld.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnector {

    private final String RDB_DRIVE = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/";

    private final String database;
    private final String user;
    private final String password;

    public SqlConnector(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL + database, user, password);
            return conn;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
