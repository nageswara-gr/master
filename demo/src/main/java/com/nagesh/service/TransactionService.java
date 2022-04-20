package com.nagesh.service;

import com.nagesh.dao.TransactionRepository;
import com.nagesh.model.AccountInfo;
import com.nagesh.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    public List<Transaction> getTransactionById(Long accNbr) {
        return transactionRepository.findByAccNr(accNbr);
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
