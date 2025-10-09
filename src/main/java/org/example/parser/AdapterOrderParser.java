package org.example.parser;

import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class AdapterOrderParser extends OrderParser {
    @Override
    public List<Order> OrderParsing(List<String> stringCustomers) {
        List<String> arrayList = new ArrayList<>();
        OrderParser orderParser = new OrderParser();
        stringCustomers.forEach(str -> {
            String replace = str.replace("#", "|");
            arrayList.add(replace);
        });
        return orderParser.OrderParsing(arrayList);
    }
}
