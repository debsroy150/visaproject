package com.sample.orderservice.jdbc;

import com.sample.orderservice.object.VisaOrder;
import com.sample.orderservice.object.VisaOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisaOrderJDBCDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public VisaOrder getPendingOrder(String emailId) {
        VisaOrder ord;
        try {
            ord = (VisaOrder) jdbcTemplate.queryForObject("SELECT * FROM VISAORDER WHERE EMAILID = ? and STATUS = 'P'",
                    new Object[]{emailId}, new BeanPropertyRowMapper(VisaOrder.class));
        } catch (EmptyResultDataAccessException dex) {
            ord = null;
        }
        if (ord != null) {
            int orderId = ord.getOrderId();
            List<VisaOrderItem> ordItems = jdbcTemplate.query("SELECT * FROM VISAORDERITEM where ORDERID = ?", new Object[]{orderId}, new BeanPropertyRowMapper(VisaOrderItem.class));
            ord.setOrderItems(ordItems);
        }
        return ord;
    }

    public int createOrder(String emailId) {
        int orderId = 0;
        VisaOrder ord = null;
        jdbcTemplate.update("INSERT INTO VISAORDER (ORDERTOTAL, STATUS, EMAILID) values (0, 'P', ?)", new Object[]{emailId});
        try {
            ord = (VisaOrder) jdbcTemplate.queryForObject("SELECT * FROM VISAORDER WHERE EMAILID = ? and STATUS = 'P'",
                    new Object[]{emailId}, new BeanPropertyRowMapper(VisaOrder.class));
            orderId = ord.getOrderId();
        } catch (EmptyResultDataAccessException dex) {
            ord = null;
        }
        return orderId;
    }

    public int addToCart(int orderId, int pid, int qty, double amt, double orderTotal) {
        jdbcTemplate.update("INSERT INTO VISAORDERITEM (ORDERID, PRODUCTID, QUANTITY, AMOUNT) values (?, ? , ?, ?)",
                new Object[]{orderId, pid, qty, amt});
        jdbcTemplate.update("UPDATE VISAORDER SET ORDERTOTAL = ? WHERE ORDERID = ?", new Object[]{orderTotal,orderId});

        return orderId;
    }

    public void updateOrderStatus(int orderId, char status) {
        jdbcTemplate.update("UPDATE VISAORDER SET STATUS = ? WHERE ORDERID = ?",
                new Object[]{status, orderId});
    }
}
