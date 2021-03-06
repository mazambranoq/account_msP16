package com.misiontic.account_ms.repositories;

import java.util.List;

import com.misiontic.account_ms.models.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository < Transaction, String>{

    List<Transaction> findByUsernameOrigin(String usernameOrigin);
    List<Transaction> findByUsernameDestiny(String usernameDestiny);
    List<Transaction> findByValueGreaterThan( Integer value );
    List<Transaction> findByUsernameOriginLike(String usernameOrigin);
    List<Transaction> findByUsernameOriginIn(List<String> usernames);
    List<Transaction> findByIdIn(List<String> ids);
}
