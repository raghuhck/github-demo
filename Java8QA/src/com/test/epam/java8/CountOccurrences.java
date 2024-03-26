package com.test.epam.java8;

import java.util.*;

public class CountOccurrences {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, Arrays.asList(new Item(123), new Item(456), new Item(123))));
        transactions.add(new Transaction(2, Arrays.asList(new Item(789), new Item(123), new Item(456))));
        transactions.add(new Transaction(3, Arrays.asList(new Item(123), new Item(123), new Item(789))));
        
        int itemIdToCount = 123;
        int totalCount = countItems(transactions, itemIdToCount);
        
        System.out.println("Total count of item with ID " + itemIdToCount + ": " + totalCount);
    }
    
    public static int countItems(List<Transaction> transactions, int itemId) {
        int totalCount = 0;
        for (Transaction transaction : transactions) {
            for (Item item : transaction.getItems()) {
                if (item.getItemId() == itemId) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
    
    public static long countItemsJava8(List<Transaction> transactions, int itemId) {
        return transactions.stream()
                .flatMap(transaction -> transaction.getItems().stream())
                .filter(item -> item.getItemId() == itemId)
                .count();
    }
}

class Transaction {
    private int transactionId;
    private List<Item> items;

    public Transaction(int transactionId, List<Item> items) {
        this.transactionId = transactionId;
        this.items = items;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private int itemId;

    public Item(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }
}

