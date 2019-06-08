package com.sample.orderservice.service;

import com.sample.orderservice.jdbc.VisaOrderJDBCDao;
import com.sample.orderservice.object.VisaOrder;
import com.sample.orderservice.object.VisaOrderItem;
import com.sample.orderservice.object.VisaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderService {

    @Autowired
    VisaOrderJDBCDao visaOrderJDBCDao;

    public int createOrder(String emailId) {
        return visaOrderJDBCDao.createOrder(emailId);
    }

    public int addToCart(int orderId, int pid, int qty, double amt, double orderTotal) {

        final String getProductURI = "http://localhost:8080/product/"+pid;
        String reduceQuantityURI = "http://localhost:8080/product/reduce/"+pid+"?_qty=";


        RestTemplate restTemplate = new RestTemplate();
        VisaProduct product = restTemplate.getForObject(getProductURI, VisaProduct.class);
        if (product.getQuantity() >= qty) {
            try {
                orderId = visaOrderJDBCDao.addToCart(orderId, pid, qty, amt, orderTotal);

                reduceQuantityURI = reduceQuantityURI+(product.getQuantity() - qty);

                restTemplate.put(reduceQuantityURI, null);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            //Do nothing
        }
        return orderId;
    }

    public VisaOrder getPendingOrder(String emailId) {
        return visaOrderJDBCDao.getPendingOrder(emailId);
    }

    public void updateOrderStatus(int orderId, char status) {
        visaOrderJDBCDao.updateOrderStatus(orderId, status);
    }
}
