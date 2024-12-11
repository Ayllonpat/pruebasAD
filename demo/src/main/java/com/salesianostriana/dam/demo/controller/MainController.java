package com.salesianostriana.dam.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/producto/123")
    public Producto getProducto(){
        return new Producto(123L, "un producto molon");
    }

    @PostMapping("/producto")
    public Producto nuevoProducto(@RequestBody Producto producto){
        return producto;
    }

    record Producto (Long id, String nombre){ }
}

