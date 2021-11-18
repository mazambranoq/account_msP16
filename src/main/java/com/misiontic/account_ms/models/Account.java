package com.misiontic.account_ms.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {
    
    @Id
    private String username;
    private int balance;
    private Date lastChange;

    public Account(String username, int balance, Date lastChange) {
        this.username = username;
        this.balance = balance;
        this.lastChange = lastChange;
    }

    public void setUsername( String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    
    
}
