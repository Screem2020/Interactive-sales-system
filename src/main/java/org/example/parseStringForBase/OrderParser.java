package org.example.parseStringForBase;

import org.example.сustomer.Customer;

import java.time.LocalDateTime;
import java.util.*;

public class OrderParser {

    private static final Integer DATE_INDEX = 0;
    private static final Integer NAME_COMPANY = 1;
    private static final Integer WIGHT_PRODUCT = 2;

    public List<Customer> OrderParsing(List<String> stringCustomers) {
        List<Customer> listCustomer = new ArrayList<>();
        for (String s : stringCustomers) {
            String[] split = s.split("\\|");
            listCustomer.add(new Customer(split[1], Integer.parseInt(split[2]), LocalDateTime.parse(split[0])));
        }
        listCustomer.sort(Comparator.comparing(Customer::getLocalDateTime));
        return listCustomer;
    }
}
