package com.sample.catalogservice.object;

import org.springframework.stereotype.Component;

@Component
public class VisaProduct {

    private int id;
    private String name;
    private String desc;
    private double amount;
    private int quantity;

    public VisaProduct() {
    }

    public VisaProduct(int id, String name, String desc, double amount, int quantity) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.amount = amount;
        this.quantity = quantity;
    }

    public VisaProduct(String name, String desc, double amount, int quantity) {
        this.name = name;
        this.desc = desc;
        this.amount = amount;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
