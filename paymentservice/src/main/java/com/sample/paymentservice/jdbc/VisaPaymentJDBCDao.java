package com.sample.paymentservice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VisaPaymentJDBCDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addPayment(int orderId, int mcard, double amount, String reason) {
        if (reason == null)
            jdbcTemplate.update("INSERT INTO ORDPAYINFO (ORDERID, MCARD, AMOUNT, STATUS, REASON) values (?, ?, ?, 'C', ?)", new Object[]{orderId,mcard, amount, reason});
        else
            jdbcTemplate.update("INSERT INTO ORDPAYINFO (ORDERID, MCARD, AMOUNT, STATUS, REASON) values (?, ?, ?, 'X', ?)", new Object[]{orderId,mcard, amount, reason});
    }
}
