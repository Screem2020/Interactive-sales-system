package org.example.сustomer;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Customer {
    private String nameCompany;
    private int wight;
    private LocalDateTime localDateTime;

    public Customer(String nameCompany, int wight, LocalDateTime localDateTime) {
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

    public int getWight() {
        return wight;
    }

    @Override
    public String toString() {
        return nameCompany + " \\| " + wight;
    }
}
