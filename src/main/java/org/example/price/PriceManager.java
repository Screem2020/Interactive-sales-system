package org.example.price;

import org.example.discunter;
import org.example.product.Cement;
import org.example.сustomer.Customer;

import java.util.ArrayList;
import java.util.List;

public class PriceManager implements discunter {

    private List<String> listPrice = new ArrayList<>();

    public List<String> getPriceForList(List<Customer> listProduct) {
        int priceWithoutDiscount;
        for (Customer customer : listProduct) {
            priceWithoutDiscount = (customer.getWight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;
            int priceWithDiscount = priceWithoutDiscount - (dinamicDiscount() * (priceWithoutDiscount / 100));
            if (priceWithDiscount < VALUE_PRICE_CEMENT) {
                listPrice.add(customer.getNameCompany() + "  " + priceWithDiscount);
            }else {
                listPrice.add(customer.getNameCompany() + " " + priceWithoutDiscount);
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
