package org.example;

import org.example.service.InlineRepresentationOrder;
import org.example.service.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        PriceManager priceManager = new PriceManager();
//        ArrayList<Cement> listCement = new ArrayList<>();
//        Cement cement = new Cement(50);
//        Cement cement2 = new Cement(50);
//        Cement cement3 = new Cement(50);
//        listCement.add(cement);
//        listCement.add(cement2);
//        listCement.add(cement3);
//        List<Integer> priceForList = priceManager.getPriceForList(listCement);
//        System.out.println(priceForList);

        ReadFile readFile = new ReadFile();
        InlineRepresentationOrder inlineRepresentationOrder = new InlineRepresentationOrder();
        List<String> strings = readFile.readFileForBase();
        inlineRepresentationOrder.representationString(strings);

    }
}
