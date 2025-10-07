<<<<<<<< HEAD:src/main/java/org/example/model/Order.java
package org.example.model;
========
package org.example.orderCompany;
>>>>>>>> 7d81e59e374205f3dc826a7f02bc8a1013851e86:src/main/java/org/example/orderCompany/Order.java

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
