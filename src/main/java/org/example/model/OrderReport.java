package org.example.report;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderReport that = (OrderReport) o;
        return Objects.equals(nameCompany, that.nameCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameCompany);
    }
}
