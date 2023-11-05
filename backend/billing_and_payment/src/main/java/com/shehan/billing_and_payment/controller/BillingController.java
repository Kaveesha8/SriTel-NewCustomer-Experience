package com.shehan.billing_and_payment.controller;
import com.shehan.billing_and_payment.model.Balance;
import com.shehan.billing_and_payment.model.Bill;
import com.shehan.billing_and_payment.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/view-bill/{accountId}")
    public List<Bill> viewBill(@PathVariable String accountId) {
        return billingService.getBills(accountId);
    }

    @PostMapping("/generate-bill")
    public Bill generateBill(@RequestBody Bill bill) {
        return billingService.generateBill(bill);
    }

    @PostMapping("/pay-bill")
    public String payBill(@RequestBody Bill bill) {
        return billingService.payBill(bill);
    }

    @GetMapping("/view-balance/{accountId}")
    public Balance viewBalance(@PathVariable String accountId) {
        return billingService.getBalance(accountId);
    }

    @PostMapping("/reload")
    public Balance reload(@RequestBody Balance balance) {
        return billingService.reload(balance);
    }

    @PostMapping("/deduct")
    public Balance deduct(@RequestBody Balance balance) {
        return billingService.deduct(balance);
    }
}

