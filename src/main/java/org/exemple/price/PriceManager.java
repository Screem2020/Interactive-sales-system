package org.exemple.price;

import org.exemple.Idiscount;
import org.exemple.product.Cement;

import java.util.ArrayList;
import java.util.List;

public class PriceManager implements Idiscount {

    private List<Integer> listPrice = new ArrayList<>();

    public List<Integer> getPriceForList(List<Cement> listProduct) {
        int priceWithoutDiscount;
        for (Cement cement : listProduct) {
            priceWithoutDiscount = (cement.getWeight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;
            int priceWithDiscount = priceWithoutDiscount - (dinamicDiscount() * (priceWithoutDiscount / 100));
            if (priceWithDiscount < VALUE_PRICE_CEMENT) {
                listPrice.add(priceWithDiscount);
            }else {
                listPrice.add(priceWithoutDiscount);
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
