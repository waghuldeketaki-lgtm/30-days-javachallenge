import java.util.*;

// Product Class
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void display() {
        System.out.println(id + " | " + name + " | ₹" + price);
    }
}

// Cart Item Class
class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }
}

// Main System Class
public class SuperShopManagementSystem {

    static ArrayList<Product> productList = new ArrayList<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Pre-loaded products
        productList.add(new Product(1, "Rice", 60));
        productList.add(new Product(2, "Sugar", 45));
        productList.add(new Product(3, "Milk", 30));
        productList.add(new Product(4, "Soap", 25));
        productList.add(new Product(5, "Biscuits", 20));

        int choice;

        do {
            System.out.println("\n===== SUPER SHOP MANAGEMENT SYSTEM =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    generateBill();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // View Products
    static void viewProducts() {
        System.out.println("\n--- Product List ---");
        for (Product p : productList) {
            p.display();
        }
    }

    // Add to Cart
    static void addToCart() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product selectedProduct = null;

        for (Product p : productList) {
            if (p.getId() == id) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        cart.add(new CartItem(selectedProduct, qty));
        System.out.println("Product added to cart!");
    }

    // View Cart
    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\n--- Cart Items ---");
        for (CartItem item : cart) {
            System.out.println(item.product.getName() + 
                " | Qty: " + item.quantity + 
                " | Total: ₹" + item.getTotal());
        }
    }

    // Generate Bill
    static void generateBill() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double grandTotal = 0;

        System.out.println("\n======= BILL =======");
        for (CartItem item : cart) {
            double total = item.getTotal();
            grandTotal += total;

            System.out.println(item.product.getName() +
                " x " + item.quantity +
                " = ₹" + total);
        }

        System.out.println("----------------------");
        System.out.println("Grand Total: ₹" + grandTotal);
        System.out.println("======================");

        cart.clear();
    }
}
