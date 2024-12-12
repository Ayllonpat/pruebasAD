package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.model.Product;
import com.salesianostriana.dam.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

   /* @GetMapping
    public ResponseEntity<List<Product>> getAll(){

        List<Product> result = productRepository.getAll();

        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }*/
    @GetMapping
    public ResponseEntity<List<Product>> getAll(
        @RequestParam(required = false,
                value = "maxPrice", defaultValue = "-1") double max,
        @RequestParam( required = false,
        value = "sort", defaultValue = "no")String sortDirection
    ){
        List<Product> result = productRepository.query(max, sortDirection);
        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.of(
                productRepository.get(id)
        );
    }

    @PostMapping
    public  ResponseEntity<Product> create(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.add(product));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.of(
                productRepository.edit(id, product)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
