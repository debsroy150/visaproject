package com.sample.catalogservice.service;

import com.sample.catalogservice.jdbc.VisaProductJDBCDao;
import com.sample.catalogservice.object.VisaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    VisaProduct product;

    @Autowired
    VisaProductJDBCDao visaProductJDBCDao;

    public VisaProduct productDetails(int productId){

        return visaProductJDBCDao.findByProductId(productId);
    }

    public List<VisaProduct> productAll() {
        return visaProductJDBCDao.findAll();

    }

    public void reduceInventory(int productId, int quantity) {
        visaProductJDBCDao.reduceInventory(productId,quantity);
    }
}
