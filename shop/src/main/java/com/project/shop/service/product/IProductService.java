package com.project.shop.service.product;

import com.project.shop.model.Product;
import com.project.shop.request.AddProductRequest;
import com.project.shop.request.UpdateProductRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest p );
    List<Product> getAllProduct();
    Product getProductById( Long id );
    void  deleteProductById(Long id);
    void UpdateProduct(UpdateProductRequest updateProductRequest,Long productId);


    List<Product> getProductByCategor(String category);
List<Product> getProductByBrand(String brand);
List<Product> getProductByCategoryAndBrand(String category,String Brand);
List<Product> getProductByName(String name);
List<Product> getProductByBrandAndName(String brand,String name );
Long CountProductsByBrandAndName(String brand,String name);

}
