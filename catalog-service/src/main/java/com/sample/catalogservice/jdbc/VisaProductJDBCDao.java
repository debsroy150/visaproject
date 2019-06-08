package com.sample.catalogservice.jdbc;

import com.sample.catalogservice.object.VisaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VisaProductJDBCDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<VisaProduct> findAll() {
        return jdbcTemplate.query("SELECT * FROM VISAPRODUCT", new BeanPropertyRowMapper(VisaProduct.class));

    }

    public VisaProduct findByProductId(int productId) {
        return jdbcTemplate.queryForObject("SELECT * FROM VISAPRODUCT WHERE ID = ?",
                new Object[]{productId}, new BeanPropertyRowMapper<VisaProduct>(VisaProduct.class));
    }

    public void reduceInventory(int productId, int quantity) {
        jdbcTemplate.update("UPDATE VISAPRODUCT SET QUANTITY=? WHERE ID=?", new Object[]{quantity,productId});
    }
}
