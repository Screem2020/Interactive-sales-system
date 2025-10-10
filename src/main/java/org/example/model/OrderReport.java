package org.example.model;

public class OrderReport {

    private String companyName;
    private double price;

    public OrderReport(String companyName, double price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return companyName + "|" + price + "\n";
    }
}
