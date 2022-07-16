package com.example.eadtest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale{
    @Id
    private String id;
    private String SalesmanID;
    private String SalesmanName;
    private String DOS;

    @ManyToOne
    @JoinColumn(name="ProdID", referencedColumnName = "ProdID")
    private Product product;

}
