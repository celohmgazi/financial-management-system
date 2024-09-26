package database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;

public interface DataAccessInterface extends BaseQuery{
    
    @Update("CREAT TABLE IF NOT EXISTS users ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "name TEXT NOT NULL, "
        + "surname TEXT NOT NULL, "
        + "surname TEXT NOT NULL UNIQUE, "
        + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP"
        +")")
    public void createUsersTable();

    @Update("CREAT TABLE IF NOT EXISTS income ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "amount REAL NOT NULL, "
        + "source TEXT, "
        + "date_received DATE, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createIncomeTable();

    @Update("CREAT TABLE IF NOT EXISTS expenses ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "amount REAL NOT NULL, "
        + "category TEXT, "
        + "date_spent DATE, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createExpensesTable();

    @Update("CREAT TABLE IF NOT EXISTS savings (")
    public void createSavingsTable();

    @Update("CREAT TABLE IF NOT EXISTS budget (")
    public void createBudgetTable();

    @Update("CREAT TABLE IF NOT EXISTS transactions (")
    public void createTransactionsTable();
}
