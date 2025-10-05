package org.example.service;

import org.example.report.OrderReport;
import org.example.сustomer.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrderService {

    public List<OrderReport> getPriceForList(List<Order> listProduct, int valPriceCement,
                                             int valueDiscount, int packagingCement, int stepDiscount) {
        List<OrderReport> listPrice = new ArrayList<>();
        double discount = 0;
        HashSet<OrderReport> orderReports = new HashSet<>();
        HashMap<String, OrderReport> ordersHashMap = new HashMap<>();
        double priceWithoutDiscount;
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
            priceWithoutDiscount = (order.getWight() / packagingCement) * valPriceCement;
            double priceWithDiscount = priceWithoutDiscount - (discount * (priceWithoutDiscount / 100));
            OrderReport otherReport = new OrderReport(order.getNameCompany(), priceWithDiscount);

            if (!(orderReports.add(otherReport))) {
                for (int i = 0; i < listPrice.size(); i++) {
                    if (listPrice.get(i).getNameCompany().equals(order.getNameCompany())) {
                        double newPrice = listPrice.get(i).getPrice() + priceWithDiscount;
                        String nameCompany = listPrice.get(i).getNameCompany();
                        listPrice.add(new OrderReport(nameCompany, newPrice));
                        listPrice.remove(listPrice.get(i));
                    }
                }
            } else {
                listPrice.add(otherReport);
            }
        }
        return listPrice;
    }
}

