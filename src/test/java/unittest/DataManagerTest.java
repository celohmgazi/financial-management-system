package unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import database.DataAccessInterface;
import database.DataManager;
import net.lemnik.eodsql.QueryTool;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataManagerTest {

    private DataManager dataManager;
    private Connection connection;
    private DataAccessInterface dai;
    private static final String URL = "jdbc:sqlite:src/test/java/unittest/test.db";
    

    @BeforeEach
    public void setUp() throws SQLException {
        dataManager = new DataManager();
        try {
            this.connection = DriverManager.getConnection(URL);

            if (connection != null) {
                this.dai = QueryTool.getQuery(connection, DataAccessInterface.class);
                dataManager.createTables(dai);
            } else {
                System.out.println("Connection failed!");
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        dataManager.closeConnection();

        deleteDatabaseFile();
    }

    @Disabled
    @Test
    public void testUserTableCreated() throws SQLException {
        assertTrue(checkTableExists("users"));
    }

    @Disabled
    @Test
    public void testIncomeTableCreated() throws SQLException {
        assertTrue(checkTableExists("income"));
    }
    
    @Disabled
    @Test
    public void testBudgetTableCreated() throws SQLException {
        assertTrue(checkTableExists("budget"));
    }

    @Disabled
    @Test
    public void testExpensesTableCreated() throws SQLException {
        assertTrue(checkTableExists("expenses"));
    }

    @Disabled
    @Test
    public void testSavingsTableCreated() throws SQLException {
        assertTrue(checkTableExists("savings"));
    }

    @Disabled
    @Test
    public void testTransactionTableCreated() throws SQLException {
        assertTrue(checkTableExists("transactions"));
    }

    private boolean checkTableExists(String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);

        return resultSet.next();
    }

    private void deleteDatabaseFile() {
        File databaseFile = new File("src/test/java/unittest/test.db");
        
        if (databaseFile.exists()) {
            if (databaseFile.delete()) {
                System.out.println("Database file deleted successfully.");
            } else {
                System.err.println("Failed to delete the database file.");
            }
        } else {
            System.out.println("Database file does not exist.");
        }
    }
}

