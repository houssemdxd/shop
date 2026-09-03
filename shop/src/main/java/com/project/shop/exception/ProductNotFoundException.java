package com.project.shop.exception;

public class ProductNotFoundException extends RuntimeException {



    public ProductNotFoundException(String msg){
        super(msg);
    }

}
