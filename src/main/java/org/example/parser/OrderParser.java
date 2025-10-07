package org.example.parser;

import org.example.model.Order;
import java.time.LocalDateTime;
import java.util.*;

public class OrderParser {

    private static final int DATE_INDEX = 0;
    private static final int NAME_COMPANY = 1;
    private static final int WIGHT_PRODUCT = 2;

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
