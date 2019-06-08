package com.sample.orderservice.object;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Component
public class VisaOrder {
    @Id
    private int orderId;

    public List<VisaOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<VisaOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    List<VisaOrderItem> orderItems;
    private double orderTotal;
    private char status;
    private String emailId;

    public VisaOrder() {
    }


    public VisaOrder(List<VisaOrderItem> orderItems, double orderTotal, char status, String emailId) {
        this.orderItems = orderItems;
        this.orderTotal = orderTotal;
        this.status = status;
        this.emailId = emailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
