package com.misiontic.account_ms.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.misiontic.account_ms.exceptions.AccountNotFoundException;
import com.misiontic.account_ms.exceptions.InsufficientBalanceException;
import com.misiontic.account_ms.models.Account;
import com.misiontic.account_ms.models.Transaction;
import com.misiontic.account_ms.repositories.AccountRepository;
import com.misiontic.account_ms.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction transaction){

        Account accountOrigin = accountRepository.findById(transaction.getUsernameOrigin()).orElse(null);
        Account accountDestiny = accountRepository.findById(transaction.getUsernameDestiny()).orElse(null);

        if(accountOrigin == null)
            throw new AccountNotFoundException(transaction.getUsernameOrigin());
        
        if(accountDestiny == null)
            throw new AccountNotFoundException(transaction.getUsernameDestiny());

        if(accountOrigin.getBalance() - transaction.getValue() < 0)
            throw new InsufficientBalanceException();
        
        accountOrigin.setBalance(accountOrigin.getBalance() - transaction.getValue());
        accountOrigin.setLastChange(new Date());
        accountRepository.save(accountOrigin);

        accountDestiny.setBalance(accountDestiny.getBalance()+ transaction.getValue());
        accountDestiny.setLastChange(new Date());
        accountRepository.save(accountDestiny);

        transaction.setDate(new Date());
        return transactionRepository.save(transaction);

    }

    @GetMapping("/transactions/{username}")
    List<Transaction> getTransactions(@PathVariable String username){
        accountRepository.findById(username)
            .orElseThrow( () -> new AccountNotFoundException(username));
        
        List<Transaction> originTransactions = transactionRepository.findByUsernameOrigin(username);
        List<Transaction> destinyTransactions = transactionRepository.findByUsernameDestiny(username);

        // originTransactions.addAll(destinyTransactions);
        // return originTransactions;

        List<Transaction> transactions = Stream.concat(originTransactions.stream(), destinyTransactions.stream()).collect(Collectors.toList());
        return transactions;

    }

    @GetMapping("/transactionsover/{value}")
    List<Transaction> getTransactionsOver( @PathVariable Integer value){
        return transactionRepository.findByValueGreaterThan(value);
    }

    @GetMapping("/transactionslike/{username}")
    List<Transaction> getTransactionslike( @PathVariable String username){
        return transactionRepository.findByUsernameOriginLike(username);
    }

    @GetMapping("/transactionsfrom")
    List<Transaction> getFilteredTransactions(){
        List <String> usernames = Arrays.asList("manuel", "sergio", "karen");
        return transactionRepository.findByUsernameOriginIn(usernames);
    }

    @GetMapping("/transactionbyid/{id}")
    Transaction getTransactionById(@PathVariable String id){
        return transactionRepository.findById(id).orElse(null);
    }

}
