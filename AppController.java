package com.nagesh.controller;

import com.nagesh.model.AccountInfo;
import com.nagesh.model.Transaction;
import com.nagesh.service.AccountService;
import com.nagesh.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    AccountService accountService;
    @Autowired
    TransactionService transactionService;

    /** Get All Accounts from Table
     *
     * @return ResponseEntity<List<AccountInfo>>
     */
    @RequestMapping(value = "/accounts/get", method = RequestMethod.GET)
    public ResponseEntity<List<AccountInfo>> getAllAccounts(){
        List<AccountInfo> accountInfoList = accountService.getAllAccounts();
        if(accountInfoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountInfoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/add", method = RequestMethod.POST)
    public ResponseEntity<String> addAccount(@RequestBody AccountInfo accountInfo){
        String status = accountService.createAccount(accountInfo);
        if("SUCCESS".equals(status))
            return new ResponseEntity<>("Account Created Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Account not Created", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/transaction/{accNr}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionsByAccNr(@PathVariable long accNr){
        List<Transaction> transactionList =  transactionService.getTransactionById(accNr);
        if(transactionList.isEmpty()){
            return new ResponseEntity<>(transactionList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @RequestMapping(value = "/transaction/{accNr}/debit", method = RequestMethod.POST)
    public ResponseEntity<String> transactionDebit(@PathVariable long accNr, @RequestBody Transaction transaction){
        Optional<AccountInfo> optional = accountService.getAccountById(accNr);
        if(optional.isPresent()){
            AccountInfo accountInfo = optional.get();
            double amount = accountInfo.getTotalAmount() - transaction.getDbtAmount();
            accountInfo.setTotalAmount(amount);
            accountService.saveAccount(accountInfo);
            transactionService.addTransaction(transaction);
            return new ResponseEntity<String>("Successfully Debited", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("No Account found for an ID "+accNr, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/transaction/{accNr}/credit", method = RequestMethod.POST)
    public ResponseEntity<String> transactionCredit(@PathVariable long accNr, @RequestBody Transaction transaction){
        Optional<AccountInfo> optional = accountService.getAccountById(accNr);
        if(optional.isPresent()){
            AccountInfo accountInfo = optional.get();
            double amount = accountInfo.getTotalAmount() + transaction.getCrdAmount();
            accountInfo.setTotalAmount(amount);
            accountService.saveAccount(accountInfo);
            transactionService.addTransaction(transaction);
            return new ResponseEntity<String>("Successfully Credited", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("No Account found for an ID "+accNr, HttpStatus.NOT_FOUND);
        }

    }


}
