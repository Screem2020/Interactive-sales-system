package org.example.parser;

import org.example.model.Order;
import java.util.List;

public class TxtOrderParsing implements OrderParser {

    @Override
    public List<Order> parse(List<String> stringList) {
        return new OrderMapper().map(stringList,"\\|");
    }
}
