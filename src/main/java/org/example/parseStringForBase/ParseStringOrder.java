package org.example.parseStringForBase;

import org.example.сustomer.Customer;

import java.time.LocalDateTime;
import java.util.*;

public class ParseStringOrder {

    private List<Customer> listCustomer = new ArrayList<>();

    public List<Customer> OrderParsing(List<String> stringCustomers) {
        String nameCompany = "";
        int wight = 0;
        LocalDateTime date = null;
        int index = 0;
        for (String s : stringCustomers) {
            if (index > 2) {
                index = 0;
                Customer customer = new Customer(nameCompany, wight, date);
                listCustomer.add(customer);
            }
            String[] split = s.split("\\|");
            if (index == 0) {
                date = LocalDateTime.parse(split[index]);
                index++;
            } if (index == 1) {
                nameCompany = split[index];
                index++;
            } if (index == 2) {
                wight = Integer.parseInt(split[index]);
            }
            index++;
        }
        listCustomer.sort(Comparator.comparing(Customer::getLocalDateTime));
        return listCustomer;
    }
}
