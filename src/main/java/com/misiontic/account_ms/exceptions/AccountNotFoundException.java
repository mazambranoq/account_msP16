package com.misiontic.account_ms.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message) {
        super("No se encontró una cuenta con el nombre de usuario: " + message);
    }
    
}
