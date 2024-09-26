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

    @Update("CREAT TABLE IF NOT EXISTS savings ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "goal_name TEXT NOT NULL, "
        + "goal_amount REAL NOT NULL, "
        + "current_amount REAL, "
        + "start_date DATE, "
        + "end_date DATE, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createSavingsTable();

    @Update("CREAT TABLE IF NOT EXISTS budget ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "monthly_budget REAL NOT NULL, "
        + "date_created DATE, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createBudgetTable();

    @Update("CREAT TABLE IF NOT EXISTS transactions (")
    public void createTransactionsTable();
}
