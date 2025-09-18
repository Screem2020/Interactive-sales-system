package org.exemple;

import org.exemple.product.Cement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cement cement = new Cement(500, 1000);
        int discount = cement.discount();
        System.out.println(discount);
        ArrayList<Object> objects = new ArrayList<>();
    }
}
