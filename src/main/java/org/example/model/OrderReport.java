package org.example.model;

public class OrderReport {

    private String nameCompany;
    private double price;

    public OrderReport(String nameCompany, double price) {
        this.nameCompany = nameCompany;
        this.price = price;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "OrderReport{" +
                "nameCompany='" + nameCompany + '\'' +
                ", price=" + price +
                '}';
    }
}
