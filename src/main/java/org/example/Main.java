package org.example;

import org.example.io.FIleUtil;
import org.example.parser.OrderParser;
import org.example.process.OrderManager;
import org.example.service.OrderService;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        new OrderManager(new FIleUtil(), new OrderService(), new OrderParser())
                .orderManager(new File("base/discount_order_customer.txt"),
               new File("base/discount_day.txt"), 10, 50, 5);
    }
}
