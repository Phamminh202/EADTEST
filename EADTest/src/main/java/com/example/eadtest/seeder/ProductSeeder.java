package com.example.eadtest.seeder;

import com.example.eadtest.entity.Product;
import com.example.eadtest.repository.ProductRepository;
import com.example.eadtest.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class ProductSeeder {

    public static List<Product> products;
    public static final int NUMBER_OF_PRODUCT = 100;

    @Autowired
    ProductRepository productRepository;

    public void generate() {
        log.debug("------------Seeding product-------------");
        products = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product product = new Product();
            product.setProdID(UUID.randomUUID().toString());
            product.setProdName(faker.name().name());
            product.setPrice(new BigDecimal(NumberUtil.getRandomNumber(100, 1000) * 1000));
            product.setDescription(faker.lorem().sentence());
            product.setDateOfManf(LocalDateTime.now());
            products.add(product);
        }
        productRepository.saveAll(products);
        log.debug("--------------End of seeding product-------------");
    }
}
