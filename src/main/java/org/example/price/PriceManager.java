package org.example.price;

import org.example.Discounter;
import org.example.report.ByerWithReport;
import org.example.сustomer.Customer;

import java.util.ArrayList;
import java.util.List;

public class PriceManager implements Discounter {

    private List<ByerWithReport> listPrice = new ArrayList<>();

    public List<ByerWithReport> getPriceForList(List<Customer> listProduct) {
        int priceWithoutDiscount;
        ByerWithReport byerWithReport = null;
        for (Customer customer : listProduct) {
            try {
                if (customer.getWight() < 50) {
                    throw new IllegalArgumentException("Incorrect volume of cement wight");
                }
                priceWithoutDiscount = (customer.getWight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;
                int priceWithDiscount = priceWithoutDiscount - (dinamicDiscount() * (priceWithoutDiscount / 100));
                if (priceWithDiscount > VALUE_PRICE_CEMENT) {
                     byerWithReport = new ByerWithReport(customer.getNameCompany(), (priceWithDiscount));
                    listPrice.add(byerWithReport);
                    } else {
                        listPrice.add(byerWithReport);
                    }
            } catch (RuntimeException e) {
                System.err.println(e + " (" + customer.getNameCompany() + " " + customer.getWight() + ")");
            }
        }
        return listPrice;
    }

    @Override
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

