package com.misiontic.account_ms.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message) {
        super("No se encontrĂ³ una cuenta con el nombre de usuario: " + message);
    }
    
}
