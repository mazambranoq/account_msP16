package com.misiontic.account_ms.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Transaction {

    @Id
    private String id;
    private String usernameOrigin;
    private String usernameDestiny;
    private int value;
    private Date date;
    
    public Transaction(String id, String usernameOrigin, String usernameDestiny, int value, Date date) {
        this.id = id;
        this.usernameOrigin = usernameOrigin;
        this.usernameDestiny = usernameDestiny;
        this.value = value;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernameOrigin() {
        return usernameOrigin;
    }

    public void setUsernameOrigin(String usernameOrigin) {
        this.usernameOrigin = usernameOrigin;
    }

    public String getUsernameDestiny() {
        return usernameDestiny;
    }

    public void setUsernameDestiny(String usernameDestiny) {
        this.usernameDestiny = usernameDestiny;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
