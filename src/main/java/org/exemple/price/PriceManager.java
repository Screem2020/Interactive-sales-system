package org.exemple.price;

import org.exemple.Idiscount;
import org.exemple.product.Cement;

import java.util.ArrayList;
import java.util.List;

public class PriceManager implements Idiscount {

    private List<Integer> listPrice = new ArrayList<>();

    public List<Integer> getPriceForList(List<Cement> listCement) {
        int priceWithoutDiscount = (listCement.getFirst().getWeight() / VALUE_PACKAGING_CEMENT) * VALUE_PRICE_CEMENT;         //цена без скидки           (вес /50 - фасовка цемента)  * 500 - цена за 50кг
        listPrice.add(priceWithoutDiscount - (dinamicDiscount() * (priceWithoutDiscount / 100)));
        return listPrice;
    }

    @Override
    public int dinamicDiscount() {
        if (listPrice.isEmpty()) {
            listPrice.add(VALUE_DISCOUNT);
        } else {
            listPrice.add(VALUE_DISCOUNT - 5 * listPrice.size());
        }
        return listPrice.getLast();
    }

    @Override
    public String toString() {
        return "PriceManager{" +
                "listPrice=" + listPrice +
                '}';
    }
}
