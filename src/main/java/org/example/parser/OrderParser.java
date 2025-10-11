package org.example.parser;

import org.example.model.Order;

import java.util.List;

public interface OrderParser {
    List<Order> OrderParsing(List<String> stringCustomers);
    List<Order> noneOrderParser(List<String> arrList);

}
