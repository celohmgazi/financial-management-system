package database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;

public interface DataAccessInterface extends BaseQuery{
    
    @Update("CREAT TABLE IF NOT EXISTS users (")
    public void createUsersTable();

    @Update("CREAT TABLE IF NOT EXISTS income (")
    public void createIncomeTable();

    @Update("CREAT TABLE IF NOT EXISTS expenses (")
    public void createExpensesTable();

    @Update("CREAT TABLE IF NOT EXISTS savings (")
    public void createSavingsTable();

    @Update("CREAT TABLE IF NOT EXISTS budget (")
    public void createBudgetTable();

    @Update("CREAT TABLE IF NOT EXISTS transactions (")
    public void createTransactionsTable();
}
