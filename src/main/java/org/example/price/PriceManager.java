package org.example.price;

import org.example.report.OrderReport;
import org.example.сustomer.Customer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PriceManager {

    private List<OrderReport> listPrice = new ArrayList<>();
    private static final int VALUE_PRICE_CEMENT = 500;
    private static final int VALUE_DISCOUNT = 50;
    private static final int VALUE_PACKAGING_CEMENT = 50;

    public List<OrderReport> getPriceForList(List<Customer> listProduct) {
        double discount = 0;
        HashSet<OrderReport> orderReports = new HashSet<>();
        double priceWithoutDiscount;
        for (Customer customer : listProduct) {
            if (customer.getWight() < 1) {
                throw new IllegalArgumentException("Incorrect volume of cement wight");
            }
            if (VALUE_DISCOUNT > 0) {
                try {
                    if (!(listPrice.isEmpty())) {
                        if (VALUE_DISCOUNT >= 5) {
                            discount = VALUE_DISCOUNT - 5 * listPrice.size();
                        } else throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Incorrect discount step");
                }
            }
            priceWithoutDiscount = (customer.getWight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;
            double priceWithDiscount = priceWithoutDiscount - (discount * (priceWithoutDiscount / 100));
            OrderReport otherReport = new OrderReport(customer.getNameCompany(), priceWithDiscount);
            if (!(orderReports.add(otherReport))) {
                for (int i = 0; i < listPrice.size(); i++) {
                    if (listPrice.get(i).getNameCompany().equals(customer.getNameCompany())) {
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

