package org.example.service;

import org.example.report.OrderReport;
import org.example.orderCompany.Order;
import java.util.*;

public class OrderService {

    public List<OrderReport> getPriceForList(List<Order> listProduct, int valPriceCement,
                                             double valueDiscount, int stepDiscount) {
        List<OrderReport> listPrice;
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
                OrderReport duplicateOrderReport = ordersHashMap.get(order.getNameCompany());
                double sumPrice = priceWithDiscount + duplicateOrderReport.getPrice();
                ordersHashMap.put(order.getNameCompany(), new OrderReport(order.getNameCompany(), sumPrice));
            } else {
                ordersHashMap.put(order.getNameCompany(), new OrderReport(order.getNameCompany(), priceWithDiscount));
            }
        }
        listPrice = ordersHashMap.values()
                .stream()
                .toList();
        return listPrice;
    }
}

