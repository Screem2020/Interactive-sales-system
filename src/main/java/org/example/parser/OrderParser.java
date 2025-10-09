package org.example.parser;

import org.example.model.Order;
import java.time.LocalDateTime;
import java.util.*;

public class OrderParser {

    private static  int DATE_INDEX = 0;
    private static  int NAME_COMPANY = 1;
    private static  int WIGHT_PRODUCT = 2;

    public int getDateIndex() {
        return DATE_INDEX;
    }

    public int getNameCompany() {
        return NAME_COMPANY;
    }

    public int getWightProduct() {
        return WIGHT_PRODUCT;
    }

    public List<Order> OrderParsing(List<String> stringCustomers) {
            List<Order> listOrder = new ArrayList<>();
            for (String s : stringCustomers) {
                String[] split = s.split("\\|");
                listOrder.add(new Order(split[NAME_COMPANY], Integer.parseInt(split[WIGHT_PRODUCT]), LocalDateTime.parse(split[DATE_INDEX])));
            }
            listOrder.sort(Comparator.comparing(Order::getLocalDateTime));
        return listOrder;
    }


}
