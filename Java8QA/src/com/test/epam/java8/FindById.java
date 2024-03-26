package com.test.epam.java8;

import java.util.List;
import java.util.Optional;

public class FindById {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("123", "Books", 20.0),
                new Product("456", "Books", 15.0),
                new Product("789", "Electronics", 30.0),
                new Product("101", null, 25.0)
        );

        String productId = findMinimumPriceProductId(products, "Books");
        System.out.println("Product ID with minimum price in Books category: " + productId);
    }

    public static String findMinimumPriceProductId(List<Product> products, String category) {
        return products.stream()
                .filter(product -> category.equals(product.getCategory())) // Filter by category
                .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())) // Find min price
                .map(Product::getId) // Map to product ID
                .orElse(""); // Return empty string if no product found
    }
}

class Product {
    private String id;
    private String category;
    private double price;

    public Product(String id, String category, double price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

