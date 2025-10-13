package org.example.parser;

import org.example.model.Order;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class OrderMapper {

    private final String delimeitr;

    public OrderMapper(String delimeitr) {
        this.delimeitr = delimeitr;
    }

    public List<Order> OrderMapper(List<String> list) {
        return list.stream().map(this::toOrders).sorted(Comparator.comparing(Order::getLocalDateTime)).toList();
    }

    public Order toOrders(String line) {
        String[] split = line.split(delimeitr);
        return new Order(split[1],
                Integer.parseInt(split[2]),
                LocalDateTime.parse(split[0]));
    }
}
