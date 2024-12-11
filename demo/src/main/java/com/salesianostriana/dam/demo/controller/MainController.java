package com.salesianostriana.dam.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/producto")
    public Producto getProducto(){
        return new Producto(123L, "un producto molon");
    }



    record Producto (Long id, String nombre){
    }
}

