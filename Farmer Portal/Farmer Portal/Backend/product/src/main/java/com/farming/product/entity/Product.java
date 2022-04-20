package com.farming.product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ProductId")
    private Long Id;
    private String productName;
    private String productType;
    private Long Quantity;
    private Long price;

}
