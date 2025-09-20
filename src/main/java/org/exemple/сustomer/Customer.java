package org.exemple.сustomer;

import java.util.Date;

public class Customer {
    private Date time;
    private String nameCompany;
    private int wight;

    public Customer(Date time, String nameCompany, int wight) {
        this.time = time;
        this.nameCompany = nameCompany;
        this.wight = wight;
    }
}
