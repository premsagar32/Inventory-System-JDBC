import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {
    public static void main(String[] args) {
        // Change "password123" to the password you set during installation
        String url = "jdbc:mysql://localhost:3306/inventory_db";
        String user = "root";
        String password = "password123";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection Successful! Java is talking to MySQL.");
        } catch (Exception e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
    }
}
