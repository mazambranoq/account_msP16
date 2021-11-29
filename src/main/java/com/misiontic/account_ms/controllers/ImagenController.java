package com.misiontic.account_ms.controllers;

import java.io.IOException;
import java.util.List;

import com.misiontic.account_ms.models.Imagen;
import com.misiontic.account_ms.repositories.ImagenRepository;


import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/imagen")
public class ImagenController {
    
    @Autowired
    private ImagenRepository imagenRepository;

    @PostMapping()
    Imagen createImagen (@RequestParam String nombre, @RequestParam MultipartFile img){
        Imagen imagen = new Imagen();
        imagen.setNombre(nombre);
        try{
            imagen.setImagen(new Binary(BsonBinarySubType.BINARY, img.getBytes()));
        }catch(IOException ex) {
            return new Imagen();
        }
        return imagenRepository.save(imagen);
    }

    @GetMapping()
    public List<Imagen> getImangenes() {
        return imagenRepository.findAll();
    }

    @GetMapping(value = "/prueba", produces = "image/png")
    public @ResponseBody byte[] mostrarImagen(@RequestParam(name = "id") String id,@RequestParam(name = "nombre") String name) throws IOException{
        Imagen imagen =  imagenRepository.findById(id).orElse(null);
        return imagen.getImagen().getData();
        
    }
    
}
