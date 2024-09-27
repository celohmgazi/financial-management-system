package database;

public class DataRetriever {
    
    public int fetchUserId(String email, DataAccessInterface dai) {
        try {
            return dai.getUserId(email);
        } catch (Exception e) {
            System.err.println("Error fetching user ID: " + e.getMessage());
            return -1;
        }
    }
}
