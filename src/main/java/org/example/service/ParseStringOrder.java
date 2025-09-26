package org.example.service;

import org.example.сustomer.Customer;

public class ParseStringOrder {

    public Customer OrderParsing(String order) {
        String nameCompany = "";
        int wight = 0;
        String[] split = order.split("\\|");
        for (int i = 0; i < split.length; i++) {
            if (i == 1) {
                nameCompany = split[i];
            }
            if (i == 2) {
                wight = Integer.parseInt(split[i]);
            }
        }
        return new Customer(nameCompany, wight);
    }
}
