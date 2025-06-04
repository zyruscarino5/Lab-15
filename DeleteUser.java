import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteUser {
    private final DatabaseConnection dbConnection;

    public DeleteUser(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void deleteUser(int id) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (Connection con = dbConnection.getConnection();
             PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            System.out.println("Record deleted successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
