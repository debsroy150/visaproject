package com.sample.orderservice.controller;

import com.sample.orderservice.object.VisaOrder;
import com.sample.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService oServ;

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public int create(@RequestParam(value="_emailId") String emailId) {
        return oServ.createOrder(emailId);
    }

    @RequestMapping(value = "/addItem", params = {"_orderId","_productId", "_quantity","_item_total", "_orderTotal"}, method = {RequestMethod.POST})
    public int addToCart(@RequestParam(value="_orderId") int orderId, @RequestParam(value="_productId") int id, @RequestParam(value="_quantity") int qty,
                         @RequestParam(value="_item_total") double amt, @RequestParam(value="_orderTotal") double orderTotal) {
        return oServ.addToCart(orderId, id, qty, amt, orderTotal);
    }

    @RequestMapping(value = "/get", params = {"_emailId"}, method = {RequestMethod.GET})
    public VisaOrder getCart(@RequestParam(value="_emailId") String emailId) {
        return oServ.getPendingOrder(emailId);
    }

    @RequestMapping(value = "/updateStatus", params = {"_orderId, _status"}, method = {RequestMethod.PUT})
    public void updateStatus(@RequestParam(value="_orderId") int orderId, @RequestParam(value="_status") char status) {
        oServ.updateOrderStatus(orderId, status);
    }
}
