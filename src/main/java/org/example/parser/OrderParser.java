package org.example.parser;

import org.example.model.Order;
import java.util.List;

public interface OrderParser {
    List<Order> parse(List<String> stringList);
}
