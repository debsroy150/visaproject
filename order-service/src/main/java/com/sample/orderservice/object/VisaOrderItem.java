package com.sample.orderservice.object;

import org.springframework.stereotype.Component;

@Component
public class VisaOrderItem {
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int orderId;
    private int productId;
    private int quantity;
    private double amount;


    public VisaOrderItem() {
    }


    public VisaOrderItem(int orderId, int productId, int quantity, double amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
