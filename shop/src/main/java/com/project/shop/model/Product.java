package com.project.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name ;
    private BigDecimal price ;
    private String description;
    private  int inventory;
    private String brand ;
@ManyToOne(cascade =CascadeType.ALL )
@JoinColumn(name = "category_id")
    private Category category ;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Image> images ;




}
