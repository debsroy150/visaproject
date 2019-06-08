package com.sample.catalogservice.controller;

import com.sample.catalogservice.object.VisaProduct;
import com.sample.catalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService pServ;

    @RequestMapping("/{id}")
    public VisaProduct getProduct(@PathVariable("id") int productId) {

        VisaProduct vProduct = pServ.productDetails(productId);
        return vProduct;
    }

    @RequestMapping("/all")
    public List<VisaProduct> getAllProduct() {

        List<VisaProduct> vProductList = pServ.productAll();

        return vProductList;
    }

    @RequestMapping(value = "/reduce/{id}", params = {"_qty"}, method = {RequestMethod.PUT})
    public void reduceInventory(@PathVariable("id") int productId, @RequestParam(value="_qty") int quantity) {
        pServ.reduceInventory(productId,quantity);
    }
}
