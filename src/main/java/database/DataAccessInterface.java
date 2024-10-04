package database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

import java.util.List;

public interface DataAccessInterface extends BaseQuery{
    
    @Update("CREATE TABLE IF NOT EXISTS users ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "name TEXT NOT NULL, "
        + "surname TEXT NOT NULL, "
        + "email TEXT NOT NULL UNIQUE, "
        + "created_at DATETIME DEFAULT CURRENT_TIMESTAMP"
        +")")
    public void createUsersTable();

    @Update("CREATE TABLE IF NOT EXISTS income ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "amount REAL NOT NULL, "
        + "source TEXT, "
        + "date_received DATETIME, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createIncomeTable();

    @Update("CREATE TABLE IF NOT EXISTS expenses ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "amount REAL NOT NULL, "
        + "category TEXT, "
        + "date_spent DATETIME, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createExpensesTable();

    @Update("CREATE TABLE IF NOT EXISTS savings ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "goal_name TEXT NOT NULL, "
        + "goal_amount REAL NOT NULL, "
        + "current_amount REAL, "
        + "start_date DATETIME, "
        + "end_date DATE, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createSavingsTable();

    @Update("CREATE TABLE IF NOT EXISTS budget ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "monthly_budget REAL NOT NULL, "
        + "date_created DATETIME, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        +")")
    public void createBudgetTable();

    @Update("CREATE TABLE IF NOT EXISTS transactions ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "user_id INTEGER, "
        + "amount REAL NOT NULL, "
        + "type TEXT, "  // Type: 'income' or 'expense'
        + "transaction_date DATETIME, "
        + "FOREIGN KEY(user_id) REFERENCES users(id)"
        + ")")
    public void createTransactionsTable();

    @Update("INSERT INTO users (name, surname, email) VALUES (?{1}, ?{2}, ?{3})")
    public void createUser(String name, String surname, String email);

    @Select("SELECT id FROM users WHERE email = ?{1}")
    public int getUserId(String email);

}
