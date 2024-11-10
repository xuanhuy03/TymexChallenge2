package challenge2;

public class Product {

    private String name;      // Product name
    private double price;     // Price per unit
    private int quantity;     // Current stock level

    // Constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate total value of the product
    public double getValue() {
        return price * quantity;
    }
}


	    


