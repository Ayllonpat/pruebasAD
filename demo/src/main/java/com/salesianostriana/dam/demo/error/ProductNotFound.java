package com.salesianostriana.dam.demo.error;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound(Long id){
        super("No hay producto con esa id");
    }

    public ProductNotFound(){
        super("No se ha encontrado ningun producto");
    }
}
