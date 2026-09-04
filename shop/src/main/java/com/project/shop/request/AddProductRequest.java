package com.project.shop.request;

import com.project.shop.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Data
public class AddProductRequest {

    private Long id;
    private String name ;
    private BigDecimal price ;
    private String description;
    private  int inventory;
    private String brand ;
    private Category category ;



}
