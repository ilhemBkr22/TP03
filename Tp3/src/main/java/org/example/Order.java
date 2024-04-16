package org.example;

public class Order {
    private long id;
    private String customerName;
    private double amount;

    public Order(long id, String customerName, double amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
