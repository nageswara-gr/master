package com.nagesh;

import com.nagesh.dao.AccountRepository;
import com.nagesh.dao.TransactionRepository;
import com.nagesh.model.AccountInfo;
import com.nagesh.model.Currency;
import com.nagesh.model.Transaction;
import com.nagesh.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication(scanBasePackages = "com.nagesh")
public class DemoApplication {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		//Adding Account Information
		AccountInfo accInfo = new AccountInfo();
		//accInfo.setAccNr(Long.parseLong("00223051012899"));
		accInfo.setAccName("Nagesh");
		accInfo.setAccType("Saving");
		accInfo.setBalanceDate(new Date());
		accInfo.setTotalAmount(Long.parseLong("50000"));
		accInfo.setCurrencyCode(Currency.fromValue("AUD"));
		accountRepository.save(accInfo);

		accInfo =  new AccountInfo();
		accInfo.setAccName("Ramesh");
		accInfo.setAccType("Current");
		accInfo.setBalanceDate(new Date());
		accInfo.setTotalAmount(Long.parseLong("100000"));
		accInfo.setCurrencyCode(Currency.fromValue("SGD"));
		accountRepository.save(accInfo);

		accInfo =  new AccountInfo();
		accInfo.setAccName("Santhosh");
		accInfo.setAccType("Saving");
		accInfo.setBalanceDate(new Date());
		accInfo.setTotalAmount(Long.parseLong("260000"));
		accInfo.setCurrencyCode(Currency.fromValue("USD"));
		accountRepository.save(accInfo);


		// Transaction History
		Transaction transaction = new Transaction();
		transaction.setAccName("Nagesh");
		transaction.setAccNr(1);
		transaction.setModeOfTransaction(TransactionType.CREDIT);
		transaction.setCurrencyCode(Currency.fromValue("AUD"));
		transaction.setValueDate(new Date());
		transaction.setCrdAmount(250.56);
		transaction.setRemarks("Amount Credited");
		transactionRepository.save(transaction);

		transaction = new Transaction();
		transaction.setAccName("Nagesh");
		transaction.setAccNr(1);
		transaction.setModeOfTransaction(TransactionType.DEBIT);
		transaction.setCurrencyCode(Currency.fromValue("AUD"));
		transaction.setValueDate(new Date());
		transaction.setDbtAmount(800.47);
		transaction.setRemarks("Amount Withdrawn");
		transactionRepository.save(transaction);

		transaction = new Transaction();
		transaction.setAccName("Nagesh");
		transaction.setAccNr(1);
		transaction.setModeOfTransaction(TransactionType.CREDIT);
		transaction.setCurrencyCode(Currency.fromValue("AUD"));
		transaction.setValueDate(new Date());
		transaction.setCrdAmount(1000.50);
		transaction.setRemarks("Amount Credited");
		transactionRepository.save(transaction);

	}

}
