package org.exemple.product;


public class Cement implements Idiscount{
    private int price;
    private int weight;

    public Cement(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int discount() {
        setPrice((Idiscount.VALUE_DISCOUNT * 500) / 100);
        return this.price;
    }

    @Override
    public String toString() {
        return "Cement{" +
                "price=" + price +
                ", weight=" + weight +
                '}';
    }
}
