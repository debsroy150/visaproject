package com.sample.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.sample.paymentservice.jdbc.VisaPaymentJDBCDao;

@Component
public class PaymentService {

    @Autowired
    VisaPaymentJDBCDao visaPaymentJDBCDao;

    public void submitPayment(int orderId, int mcard, double amount, String reason) {
        String updateOrderURI = "";
        if (reason == null) {
            updateOrderURI = "http://localhost:8081/order/updateStatus?_orderId=" + orderId + "&_status=C";
        } else {
            updateOrderURI = "http://localhost:8081/order/updateStatus?_orderId=" + orderId + "&_status=X";
        }
        visaPaymentJDBCDao.addPayment(orderId, mcard, amount, reason);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(updateOrderURI, null);
    }
}
