package com.project.shop.request;

import com.project.shop.model.Category;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class UpdateProductRequest {

    private Long id;
    private String name ;
    private BigDecimal price ;
    private String description;
    private  int inventory;
    private String brand ;
    private Category category ;


}
