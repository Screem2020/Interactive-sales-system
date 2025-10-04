package org.example.parseStringForBase;

import org.example.сustomer.Customer;

import java.time.LocalDateTime;
import java.util.*;

public class OrderParser {

    private static final int DATE_INDEX = 0;
    private static final int NAME_COMPANY = 1;
    private static final int WIGHT_PRODUCT = 2;

    public List<Customer> OrderParsing(List<String> stringCustomers) {
        List<Customer> listCustomer = new ArrayList<>();
        for (String s : stringCustomers) {
            String[] split = s.split("\\|");
            listCustomer.add(new Customer(split[NAME_COMPANY], Integer.parseInt(split[WIGHT_PRODUCT]), LocalDateTime.parse(split[DATE_INDEX])));
        }
        listCustomer.sort(Comparator.comparing(Customer::getLocalDateTime));
        return listCustomer;
    }
}
