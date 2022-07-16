package com.example.eadtest.api;

import com.example.eadtest.entity.Sale;
import com.example.eadtest.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/sales")
public class SaleApi {
    @Autowired
    SaleService saleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Sale>> getList(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Sale sale){
        return ResponseEntity.ok(saleService.save(sale));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Sale> optionalSale =  saleService.findById(id);
        if (!optionalSale.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalSale.get());
    }
}
