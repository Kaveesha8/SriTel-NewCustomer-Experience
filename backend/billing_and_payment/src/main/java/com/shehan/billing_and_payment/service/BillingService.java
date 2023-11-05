package com.shehan.billing_and_payment.service;
import com.shehan.billing_and_payment.model.Balance;
import com.shehan.billing_and_payment.model.Bill;
import com.shehan.billing_and_payment.repository.BalanceRepository;
import com.shehan.billing_and_payment.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    public List<Bill> getBills(String accountId) {
        return billRepository.findByAccountId(accountId);
    }

    public Bill generateBill(Bill bill) {
        return billRepository.save(bill);
    }

    public String payBill(Bill bill) {
        // Find the bill in the database
        Optional<Bill> optionalBill = billRepository.findById(bill.getId());

        if (optionalBill.isPresent()) {
            Bill existingBill = optionalBill.get();

            // Check if the bill has already been paid
            if ("PAID".equals(existingBill.getStatus())) {
                return "This bill has already been paid.";
            }

            // Check if the payment amount matches the bill amount
            if (!bill.getAmount().equals(existingBill.getAmount())) {
                return "The payment amount does not match the bill amount.";
            }

            // Update the bill status and payment date
            existingBill.setStatus("PAID");
            existingBill.setPaymentDate(new Date());
            billRepository.save(existingBill);

            return "Payment successful";
        } else {
            return "Bill not found";
        }
    }


    public Balance getBalance(String accountId) {
        return balanceRepository.findByAccountId(accountId);
    }

    public Balance reload(Balance balance) {
        // Find the balance in the database
        Optional<Balance> optionalBalance = Optional.ofNullable(balanceRepository.findByAccountId(balance.getAccountId()));

        if (optionalBalance.isPresent()) {
            Balance existingBalance = optionalBalance.get();

            // Add the reload amount to the existing balance
            existingBalance.setAmount(existingBalance.getAmount() + balance.getAmount());

            // Save the updated balance back to the database
            return balanceRepository.save(existingBalance);
        } else {
            // If the balance is not found, you could either throw an exception or return a new Balance object with a default value
            // Here's how you might return a new Balance object:
            return new Balance(balance.getAccountId(), 0.0);
        }
    }


    public Balance deduct(Balance balance) {
        // Find the balance in the database
        Optional<Balance> optionalBalance = Optional.ofNullable(balanceRepository.findByAccountId(balance.getAccountId()));

        if (optionalBalance.isPresent()) {
            Balance existingBalance = optionalBalance.get();

            // Deduct the amount from the existing balance
            double newAmount = existingBalance.getAmount() - balance.getAmount();
            if (newAmount < 0) {
                // If the balance is insufficient, you could either throw an exception or return a new Balance object with a default value
                // Here's how you might return a new Balance object:
                return new Balance(balance.getAccountId(), 0.0);
            }

            existingBalance.setAmount(newAmount);

            // Save the updated balance back to the database
            return balanceRepository.save(existingBalance);
        } else {
            // If the balance is not found, you could either throw an exception or return a new Balance object with a default value
            // Here's how you might return a new Balance object:
            return new Balance(balance.getAccountId(), 0.0);
        }
    }


}

