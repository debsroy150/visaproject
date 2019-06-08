package com.sample.paymentservice.controller;

import com.sample.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService tServ;

    @RequestMapping(value = "/submitSuccess", params = {"_orderId","_mCard", "_amount"}, method = {RequestMethod.POST})
    public void callbackURLSuccess(@RequestParam(value="_orderId") int orderId, @RequestParam(value="_mCard") int mCard, @RequestParam(value="amount") double amount) {
        tServ.submitPayment(orderId, mCard, amount, null);
    }

    @RequestMapping(value = "/submitFailure", params = {"_orderId","_mCard", "_amount", "_reason"}, method = {RequestMethod.POST})
    public void callbackURLFailure(@RequestParam(value="_orderId") int orderId, @RequestParam(value="_mCard") int mCard, @RequestParam(value="_amount") double amount, @RequestParam(value="_reason") String reason) {
        tServ.submitPayment(orderId, mCard, amount, reason);
    }

}
