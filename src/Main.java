import challenge2.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 999.99, 5));
        productList.add(new Product("Smartphone", 499.99, 10));
        productList.add(new Product("Tablet", 299.99, 0));
        productList.add(new Product("Smartwatch", 199.99, 3));

        // Calculate total inventory value
        double totalValue = calculateTotalInventoryValue(productList);
        System.out.printf("Total Inventory Value: $%.2f%n", totalValue);

        // Find the most expensive product
        String mostExpensiveProduct = findMostExpensiveProduct(productList);
        System.out.println("Most Expensive Product: " + mostExpensiveProduct);

        // Check if "Headphones" is in stock
        boolean isHeadphonesInStock = checkProductInStock(productList, "Headphones");
        System.out.println("Is 'Headphones' in stock? " + isHeadphonesInStock);

        // Sort products by price (descending)
        List<Product> sortedByPriceDesc = sortProducts(productList, "price", false);
        System.out.println("Products sorted by price (descending):");
        printProductList(sortedByPriceDesc);

        // Sort products by quantity (ascending)
        List<Product> sortedByQuantityAsc = sortProducts(productList, "quantity", true);
        System.out.println("Products sorted by quantity (ascending):");
        printProductList(sortedByQuantityAsc);

        // Challenge 2.2: find missing number
        System.out.println("=== Challenge 2.2: find missing number ===");
        int[] inputArray = {3, 7, 1, 2, 6, 4}; // n = 6, missing number is 5
        int missingNumber = findMissingNumber(inputArray);
        System.out.println("The missing number is: " + missingNumber); // Output: 5
    }

    public static double calculateTotalInventoryValue(List<Product> products) {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getValue();
        }
        return totalValue;
    }

    public static String findMostExpensiveProduct(List<Product> products) {
        Product mostExpensive = Collections.max(products, Comparator.comparing(Product::getPrice));
        return mostExpensive.getName();
    }

    public static boolean checkProductInStock(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product.getQuantity() > 0;
            }
        }
        return false;
    }

    public static List<Product> sortProducts(List<Product> products, String sortBy, boolean ascending) {
        Comparator<Product> comparator;
        if (sortBy.equals("price")) {
            comparator = Comparator.comparing(Product::getPrice);
        } else {
            comparator = Comparator.comparing(Product::getQuantity);
        }
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Collections.sort(products, comparator);
        return products;
    }

    public static void printProductList(List<Product> products) {
        for (Product product : products) {
            System.out.printf("%s: $%.2f, Quantity: %d%n", product.getName(), product.getPrice(), product.getQuantity());
        }
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length;  // Length of the array (which is n)
        // Calculate the expected sum of numbers from 1 to n + 1
        int expectedSum = (n + 1) * (n + 2) / 2;
        // Calculate the actual sum of the elements in the array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        // The missing number is the difference between expected and actual sums
        return expectedSum - actualSum;
    }

}