package com.example.eadtest.service;

import com.example.eadtest.entity.Product;
import com.example.eadtest.entity.Sale;
import com.example.eadtest.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Iterable<Sale> findAll(){
        return saleRepository.findAll();
    }

    public Optional<Sale> findById(String id){
        return saleRepository.findById(id);
    }

    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }
}
