package com.nagesh.service;

import com.nagesh.dao.AccountRepository;
import com.nagesh.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<AccountInfo> getAllAccounts() {
        return accountRepository.findAll();
    }

    public String createAccount(AccountInfo accountInfo) {
       AccountInfo response = accountRepository.save(accountInfo);
       return response != null ? "SUCCESS" : "FAILURE";
    }

    public Optional<AccountInfo> getAccountById(long accNr) {
        return accountRepository.findById(accNr);
    }

    public void saveAccount(AccountInfo accountInfo) {
        accountRepository.save(accountInfo);
    }
}
