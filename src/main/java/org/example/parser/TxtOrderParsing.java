package org.example.parser;

import org.example.model.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TxtOrderParsing implements OrderParser {

    private static int DATE_INDEX = 0;
    private static int NAME_COMPANY = 1;
    private static int WIGHT_PRODUCT = 2;

    @Override
    public List<Order> orderParsing(List<String> stringList) {
        List<Order> listOrder = new ArrayList<>();
        for (String s : stringList) {
            String[] split = s.split("\\|");
            listOrder.add(new Order(split[NAME_COMPANY], Integer.parseInt(split[WIGHT_PRODUCT]), LocalDateTime.parse(split[DATE_INDEX])));
        }
        listOrder.sort(Comparator.comparing(Order::getLocalDateTime));
        return listOrder;
    }
}
