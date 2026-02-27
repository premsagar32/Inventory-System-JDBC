import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryDAO dao = new InventoryDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- DATABASE INVENTORY SYSTEM ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Price: "); double price = sc.nextDouble();
                System.out.print("Quantity: "); int qty = sc.nextInt();
                dao.addProduct(name, price, qty);
            } else if (choice == 2) {
                dao.getAllProducts().forEach(Product::display);
            } else if (choice == 3) {
                break;
            }
        }
    }
}