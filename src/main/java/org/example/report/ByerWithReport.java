package org.example.report;

public class ByerWithReport {

    private String nameCompany;
    private int price;

    public ByerWithReport(String nameCompany, int price) {
        this.nameCompany = nameCompany;
        this.price = price;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ByerWithReport{" +
                "nameCompany='" + nameCompany + '\'' +
                ", price=" + price +
                '}';
    }
}
