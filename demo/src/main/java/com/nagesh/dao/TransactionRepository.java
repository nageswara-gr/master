package com.nagesh.dao;

import com.nagesh.model.AccountInfo;
import com.nagesh.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction save(Transaction transaction);

    List<Transaction> findByAccNr(Long accNbr);
}
