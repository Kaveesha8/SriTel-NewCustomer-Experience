package com.shehan.billing_and_payment.repository;

import com.shehan.billing_and_payment.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    Balance findByAccountId(String accountId);
}
