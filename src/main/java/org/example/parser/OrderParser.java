package org.example.parser;

import org.example.model.Order;

import java.util.List;

public interface OrderParser {
    List<Order> noneOrderParsing(List<String> stringCustomers);

    List<Order> txtOrderParsing(List<String> stringCustomers);
}
