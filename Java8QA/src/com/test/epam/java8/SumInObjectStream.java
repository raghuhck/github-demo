package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;

/*(Java 8 Stream) Shared one List holding Item class objects and the task is to sum up all the Item's quantities, 
after removing the objects holding either the name or quantity as null
*/
public class SumInObjectStream {
    static class Item {
        private String name;
        private Integer quantity;

        public Item(String name, Integer quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args) {
        List<Item> itemList = Arrays.asList(
                new Item("Item1", 10),
                new Item(null, 20),
                new Item("Item3", null),
                new Item("Item4", 30),
                new Item(null, null)
        );

        int sum = itemList.stream()
                .filter(item -> item.getName() != null && item.getQuantity() != null)
                .mapToInt(Item::getQuantity)
                .sum();

        System.out.println("Sum of quantities: " + sum);
    }
}

