package com.example.eadtest.seeder;

import com.example.eadtest.entity.Product;
import com.example.eadtest.entity.Sale;
import com.example.eadtest.repository.ProductRepository;
import com.example.eadtest.repository.SaleRepository;
import com.example.eadtest.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class SaleSeeder {

    public static List<Sale> sales;
    public static final int NUMBER_OF_SALE = 100;

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductRepository productRepository;

    public void generate() {
        log.debug("------------Seeding sale-------------");
        sales = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_OF_SALE; i++) {
            Sale sale = new Sale();

            int randomProduct = NumberUtil.getRandomNumber(0, ProductSeeder.products.size() - 1);
            Product product = ProductSeeder.products.get(randomProduct);
            sale.setProduct(product);

            sale.setId(UUID.randomUUID().toString());
            sale.setSalesmanID(faker.number().numberBetween(1,20));
            sale.setSalesmanName(faker.name().fullName());
            sale.setDOS(faker.lorem().sentence());
            sales.add(sale);
        }
        saleRepository.saveAll(sales);
        log.debug("--------------End of seeding sale-------------");
    }
}