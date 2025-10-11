package org.example.parser;

import org.example.model.Order;
import java.util.ArrayList;
import java.util.List;

public class NoneExtensionOrderParser extends TxtOrderParsing implements OrderParser {

    @Override
    public List<Order> orderParsing(List<String> stringCustomers) {
        List<String> arrayList = new ArrayList<>();
        TxtOrderParsing txtOrderParsing = new TxtOrderParsing();
        stringCustomers.forEach(str -> {
            String replace = str.replace("#", "|");
            arrayList.add(replace);
        });
        return txtOrderParsing.orderParsing(arrayList);
    }
}
