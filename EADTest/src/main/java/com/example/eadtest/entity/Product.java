package com.example.eadtest.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "productDetails")
public class Product {
    @Id
    private String ProdID;
    private String ProdName;
    private String Description;
    private LocalDateTime DateOfManf;
    private BigDecimal price;

}
