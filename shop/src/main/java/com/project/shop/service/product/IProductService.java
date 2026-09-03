package com.project.shop.service.product;

import com.project.shop.model.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product p );
    List<Product> getAllProduct();
    Product getProductById( Long id );
    void  deleteProductById(Long id);
    void UpdateProduct(Product p,Long productId);
    List<Product> getProductByCategor(String category);
List<Product> getProductByBrand(String brand);
List<Product> getProductByCategoryAndBrand(String category,String Brand);
List<Product> getProductByName(String name);
List<Product> getProductByBrandAndName(String brand,String name );
Long CountProductsByBrandAndName(String brand,String name);

}
