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

            if (ordersHashMap.containsKey(order.getNameCompany())) {
                ordersHashMap.merge(order.getNameCompany(), new OrderReport(order.getNameCompany(),
                        priceWithDiscount + ordersHashMap.get(order.getNameCompany()).getPrice()), (a,b) -> b);
            } else {
                ordersHashMap.put(order.getNameCompany(), new OrderReport(order.getNameCompany(), priceWithDiscount));
            }
        }
        return ordersHashMap.values()
                .stream()
                .toList();
    }
}

