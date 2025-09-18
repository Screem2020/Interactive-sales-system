package org.exemple.product;


import org.exemple.Idiscount;

public class Cement implements Idiscount {
    private int weight;

    public int price() {
        return VALUE_PRICE * this.weight;
    }

    public Cement(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    public int discount() {
//        this.priceWithDiscount = price() - (VALUE_DISCOUNT * price()) / 100;
//        return priceWithDiscount;
//    }
}

