package org.exemple;

import org.exemple.price.PriceManager;
import org.exemple.product.Cement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PriceManager priceManager = new PriceManager();
        ArrayList<Cement> listCement = new ArrayList<>();
        Cement cement = new Cement(50);
        Cement cement2 = new Cement(50);
        Cement cement3 = new Cement(50);
        listCement.add(cement);
        listCement.add(cement2);
        listCement.add(cement3);
        List<Integer> priceForList = priceManager.getPriceForList(listCement);
        System.out.println(priceForList);

    }
}
