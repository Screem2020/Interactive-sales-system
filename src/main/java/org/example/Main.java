package org.example;

import org.example.process.OrderManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        new OrderManager().orderManager(new File("src/main/java/org/example/base/discount_order_customer.txt"),
               new File("src/main/java/org/example/base/discount_day.txt"), 500, 50, 50, 5);

    }
}
