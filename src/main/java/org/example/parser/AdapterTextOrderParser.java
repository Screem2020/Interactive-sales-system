package org.example.parser;

import org.example.model.Order;
import java.util.ArrayList;
import java.util.List;

public class AdapterTextOrderParser extends TextOrderParser {
    @Override
    public List<Order> OrderParsing(List<String> stringCustomers) {
        List<String> arrayList = new ArrayList<>();
        TextOrderParser textOrderParser = new TextOrderParser();
        stringCustomers.forEach(str -> {
            String replace = str.replace("#", "|");
            arrayList.add(replace);
        });
        return textOrderParser.OrderParsing(arrayList);
    }
}
