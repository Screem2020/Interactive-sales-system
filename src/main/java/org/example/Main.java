package org.example;

import org.example.io.FileUtil;
import org.example.manager.OrderManager;
import org.example.parser.OrderRegister;
import org.example.service.OrderService;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        new OrderManager(new FileUtil(), new OrderService(), new OrderRegister())
                .process(new File("base/discount_order_customer.txt"),
               new File("base/discount_day.txt"), 10, 50, 5);

    }
}
