
package com.misiontic.account_ms.repositories;

import com.misiontic.account_ms.models.Imagen;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends MongoRepository<Imagen, String>{
    Imagen findByNombre( String nombre);
}
