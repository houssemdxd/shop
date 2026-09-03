package com.project.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id ;
public  String name ;
@OneToMany(mappedBy = "category")
private List<Product> products;

}
