public class Product {
        private int id;
        private String name;
        private double price;
        private int quantity;

        public Product(int id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void display() {
            System.out.printf("ID: %d | %-15s | Price: ₹%-8.2f | Qty: %d%n", id, name, price, quantity);
        }
    }
