import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    private final String url = "jdbc:mysql://localhost:3306/inventory_db";
    private final String user = "root";
    private final String password = "password123"; // USE YOUR PASSWORD

    // RESUME SKILL: PREPARED STATEMENTS (Protects against SQL Injection)
    public void addProduct(String name, double price, int qty) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, qty);
            pstmt.executeUpdate();
            System.out.println("✅ Product added to Database!");

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getInt("quantity")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}
