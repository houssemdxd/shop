package com.project.shop.exception;

public class AlreadyExistException  extends  RuntimeException{
    public AlreadyExistException(String categoryAlreadyExist) {
        super(categoryAlreadyExist);
    }
}
