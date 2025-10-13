package org.example.parser;

import org.example.model.Order;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class OrderMapper {

    public List<Order> map(List<String> list, String delimeitr) {
        return list.stream()
                .map(line -> toOrdersPars(line, delimeitr))
                .sorted(Comparator.comparing(Order::getLocalDateTime))
                .toList();
    }
    public Order toOrdersPars(String line, String delimeitr) {
        String[] split = line.split(delimeitr);
        return new Order(split[1],
                Integer.parseInt(split[2]),
                LocalDateTime.parse(split[0]));
    }
}
