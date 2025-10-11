package org.example.parser;

import org.example.model.Order;
import java.util.List;

public interface OrderParser {
    List<Order> orderParsing(List<String> stringCustomers);
}
