package com.example.eadtest.api;


import com.example.eadtest.entity.Product;
import com.example.eadtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/products")
public class ProductApi {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

}
