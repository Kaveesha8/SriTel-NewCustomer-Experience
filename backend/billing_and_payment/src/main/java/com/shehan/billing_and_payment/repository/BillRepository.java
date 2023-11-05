package com.shehan.billing_and_payment.repository;
import com.shehan.billing_and_payment.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByAccountId(String accountId);
}
