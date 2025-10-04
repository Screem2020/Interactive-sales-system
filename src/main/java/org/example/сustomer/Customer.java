package org.example.сustomer;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Customer {
    private String nameCompany;
    private double wight;
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

    public double getWight() {
        return wight;
    }

    @Override
    public String toString() {
        return nameCompany + " \\| " + wight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(nameCompany, customer.nameCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameCompany);
    }
}
