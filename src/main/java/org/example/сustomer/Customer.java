package org.example.сustomer;

public class Customer {
    private String nameCompany;
    private int wight;

    public Customer(String nameCompany, int wight) {
        this.nameCompany = nameCompany;
        this.wight = wight;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getWight() {
        return wight;
    }

    @Override
    public String toString() {
        return nameCompany + " \\| " + wight;
    }
}
