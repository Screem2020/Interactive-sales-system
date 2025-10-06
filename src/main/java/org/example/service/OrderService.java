package org.example.service;

import org.example.report.OrderReport;
import org.example.сustomer.Order;
import java.util.*;

public class OrderService {

    public List<OrderReport> getPriceForList(List<Order> listProduct, int valPriceCement,
                                             int valueDiscount, int packagingCement, int stepDiscount) {
        List<OrderReport> listPrice = new ArrayList<>();
        HashMap<String, OrderReport> ordersHashMap = new HashMap<>();
        double discount = 0;
        for (Order order : listProduct) {
            if (order.getWight() < 1) {
                throw new IllegalArgumentException("Incorrect volume of cement wight");
            }
            if (valueDiscount > 0) {
                try {
                    if (!(listPrice.isEmpty())) {
                        if (valueDiscount >= stepDiscount) {
                            discount = valueDiscount - stepDiscount * listPrice.size();
                        } else throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Incorrect discount step");
                }
            }
            double priceWithoutDiscount = (order.getWight() / packagingCement) * valPriceCement;
            double priceWithDiscount = priceWithoutDiscount - (discount * (priceWithoutDiscount / 100));
            if (ordersHashMap.containsKey(order.getNameCompany())) {
                double sumPrice;
                OrderReport duplicateOrderReport = ordersHashMap.get(order.getNameCompany());
                sumPrice = priceWithDiscount + duplicateOrderReport.getPrice();
                listPrice.add(new OrderReport(order.getNameCompany(), sumPrice));
                listPrice.remove(duplicateOrderReport);
            } else {
                OrderReport orderReport = new OrderReport(order.getNameCompany(), priceWithDiscount);
                listPrice.add(orderReport);
                ordersHashMap.put(order.getNameCompany(), orderReport);
            }
        }
        return listPrice;
    }
}

