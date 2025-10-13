package org.example.parser;

import org.example.model.Order;
import java.util.List;

public class NoneExtensionOrderParser implements OrderParser{

    @Override
    public List<Order> orderParsing(List<String> stringList) {
        return new OrderMapper("#").OrderMapper(stringList);
    }
}
