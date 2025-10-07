package org.example.model;

import java.time.LocalDateTime;

public class Order {
    private String nameCompany;
    private double wight;
    private LocalDateTime localDateTime;

    public Order(String nameCompany, int wight, LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        this.nameCompany = nameCompany;
        this.wight = wight;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public double getWight() {
        return wight;
    }

    @Override
    public String toString() {
        return nameCompany + " \\| " + wight;
    }
}
