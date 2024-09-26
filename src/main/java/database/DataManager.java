package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.lemnik.eodsql.QueryTool;

public class DataManager {

    protected DataAccessInterface dai;
    private static final String DB_NAME = "database.db";
    private static final String DB_PATH = System.getProperty("user.dir") + "/";
    private static final String URL = "jdbc:sqlite:" + DB_PATH + DB_NAME;
    protected Connection connection;
    
    public DataManager() {
        makeDAI();
    }

    public void makeDAI() {
        try {
            connection = DriverManager.getConnection(URL);

            if (connection != null) {
                this.dai = QueryTool.getQuery(connection, DataAccessInterface.class);
                createTables(dai);
            } else {
                System.out.println("Connection failed!");
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }

    public DataAccessInterface getDAI() {
        return dai;
    }

    public void createTables(DataAccessInterface dai) {
       
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
