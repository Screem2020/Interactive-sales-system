package org.example.price;

import org.example.report.OrderReport;
import org.example.сustomer.Customer;
import java.util.ArrayList;
import java.util.List;

public class PriceManager {

    private List<OrderReport> listPrice = new ArrayList<>();
    private static final int VALUE_PRICE_CEMENT = 500;
    private static final int VALUE_DISCOUNT = 50;
    private static final int VALUE_PACKAGING_CEMENT = 50;

    public List<OrderReport> getPriceForList(List<Customer> listProduct) {
        int priceWithoutDiscount;
        OrderReport orderReport = null;
        for (Customer customer : listProduct) {
            try {
                if (customer.getWight() < 50) {
                    throw new IllegalArgumentException("Incorrect volume of cement wight");
                }
                priceWithoutDiscount = (customer.getWight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;
                int priceWithDiscount = priceWithoutDiscount - (dinamicDiscount() * (priceWithoutDiscount / 100));
                if (priceWithDiscount > VALUE_PRICE_CEMENT) {
                     orderReport = new OrderReport(customer.getNameCompany(), (priceWithDiscount));
                    listPrice.add(orderReport);
                    } else {
                        listPrice.add(orderReport);
                    }
            } catch (RuntimeException e) {
                e.fillInStackTrace();
            }
        }
        return listPrice;
    }

    public int dinamicDiscount() {
        if (VALUE_DISCOUNT > 0) {
            try {
                if (listPrice.isEmpty()) {
                    return VALUE_DISCOUNT;
                } else if (VALUE_DISCOUNT >= 5) {
                    return VALUE_DISCOUNT - 5 * listPrice.size();
                } else throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Incorrect discount step");
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "PriceManager{" +
                "listPrice=" + listPrice +
                '}';
    }
}

