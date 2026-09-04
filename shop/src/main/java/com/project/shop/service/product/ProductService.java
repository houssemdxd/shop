package com.project.shop.service.product;

import com.project.shop.exception.ProductNotFoundException;
import com.project.shop.model.Category;
import com.project.shop.model.Product;
import com.project.shop.repository.CategoryRespository;
import com.project.shop.repository.ProductRepository;
import com.project.shop.request.AddProductRequest;
import com.project.shop.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{


    private final  ProductRepository productRepository;
    private final CategoryRespository categoryRespository;



    @Override
    public Product addProduct(AddProductRequest p) {
        //check id the category exist in db
        Category category = Optional.ofNullable(categoryRespository.findByName(p.getCategory().getName()))
                .orElseGet(()->{

Category newCategory =new Category(p.getCategory().getName());
return  categoryRespository.save(newCategory);

                });


p.setCategory(category);
return productRepository.save(createProduct(p,category));

    }

    private Product createProduct(AddProductRequest request, Category category){

return new Product(
request.getName(),request.getPrice(),
        request.getDescription(),

        request.getInventory(),
        request.getBrand(),
        category
                );





           }
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found !!"));
    }

    @Override
    public void deleteProductById(Long id) {
    this.productRepository.findById(id)
            .ifPresentOrElse(productRepository::delete,
                    ()->{throw new ProductNotFoundException("Product not found");});

    }

    @Override
    public void UpdateProduct(UpdateProductRequest updateProductRequest, Long productId) {
        //find product
        // check if the product exist
        //update product

        Product existingProduct = this.productRepository.findById(updateProductRequest.getId()).orElseThrow(()->{throw new ProductNotFoundException("Product not found");});
        Product newProduct =  updateThePreExistedProduct(existingProduct,updateProductRequest);
        this.productRepository.save(newProduct);
    }

    private Product updateThePreExistedProduct(Product existingProduct, UpdateProductRequest updateProductRequest) {

         existingProduct.setCategory(updateProductRequest.getCategory());
        existingProduct.setName(updateProductRequest.getName());
        existingProduct.setBrand(updateProductRequest.getBrand());
        existingProduct.setPrice(updateProductRequest.getPrice());
        existingProduct.setInventory(updateProductRequest.getInventory());
        existingProduct.setDescription(updateProductRequest.getDescription());
        return existingProduct ;




    }


    @Override
    public List<Product> getProductByCategor(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String Brand) {
        return productRepository.findByCategoryNameAndBrand(category,Brand);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByName( name);
    }

    @Override
    public List<Product> getProductByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long CountProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand,name);
    }
}
