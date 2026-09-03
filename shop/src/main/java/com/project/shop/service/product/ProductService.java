package com.project.shop.service.product;

import com.project.shop.exception.ProductNotFoundException;
import com.project.shop.model.Product;
import com.project.shop.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{


    private ProductRepository productRepository;




    @Override
    public Product addProduct(Product p) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found !!"));
    }

    @Override
    public void deleteProductById(Long id) {
    this.productRepository.findById(id).ifPresent(productRepository::delete);


    }

    @Override
    public void UpdateProduct(Product p, Long productId) {

    }

    @Override
    public List<Product> getProductByCategor(String category) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String Brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrandAndName(String brand, String name) {
        return List.of();
    }

    @Override
    public Long CountProductsByBrandAndName(String brand, String name) {
        return 0L;
    }
}
