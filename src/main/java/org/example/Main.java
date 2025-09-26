package org.example;

import org.example.price.PriceManager;
import org.example.service.ParseStringOrder;
import org.example.service.ReadFile;
import org.example.сustomer.Customer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ParseStringOrder parseStringOrder = new ParseStringOrder();
        List<String> strings = readFile.readFileForBase();
        ArrayList<Customer> listCustomer = new ArrayList<>();
        for (String s : strings) {
            listCustomer.add(parseStringOrder.OrderParsing(s));
        }
        PriceManager priceManager = new PriceManager();
        System.out.println(priceManager.getPriceForList(listCustomer) + "\n");

    }
}
