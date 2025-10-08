package org.example.service;

import org.example.model.OrderReport;
import org.example.model.Order;

import java.util.*;

public class OrderService {

    public List<OrderReport> getPriceForList(List<Order> listProduct, int valPriceCement,
                                             double valueDiscount, int stepDiscount) {
        HashMap<String, OrderReport> ordersHashMap = new HashMap<>();
        double priceWithDiscount = 0;
        for (Order order : listProduct) {
            if (valueDiscount >= 0) {
                priceWithDiscount = order.getWight() * valPriceCement - (order.getWight() * valPriceCement * (valueDiscount / 100));
                if (valueDiscount >= stepDiscount) {
                    valueDiscount -= stepDiscount;
                }
            }
            ordersHashMap.merge(order.getNameCompany(), new OrderReport(order.getNameCompany(), priceWithDiscount),
                    (existing, newValue) -> new OrderReport(existing.getNameCompany(), existing.getPrice() + newValue.getPrice()));
        }
        return ordersHashMap.values()
                .stream()
                .toList();
    }
}

