package com.misiontic.account_ms.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

public class Imagen {
    @Id
    String id;

    String nombre;

    Binary  imagen;

    public Imagen() {
    }

    public Imagen(String id, String nombre, Binary imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Binary getImagen() {
        return imagen;
    }

    public void setImagen(Binary imagen) {
        this.imagen = imagen;
    }
    
}
