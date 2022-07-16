package com.example.eadtest.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
    private Date DateOfManf;
    private BigDecimal price;

}
