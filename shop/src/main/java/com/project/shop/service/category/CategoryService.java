package com.project.shop.service.category;

import com.project.shop.exception.AlreadyExistException;
import com.project.shop.exception.CategoryNotFoundException;
import com.project.shop.exception.ResourceNotFoundException;
import com.project.shop.model.Category;
import com.project.shop.repository.CategoryRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    private  final CategoryRespository categoryRespository;

    public CategoryService(CategoryRespository categoryRespository) {
        this.categoryRespository = categoryRespository;
    }




    @Override
    public Category getCategoryById(Long id) {
        return categoryRespository.findById(id).orElseThrow(()->{

            throw  new ResourceNotFoundException("Category Not Found !!");

        });
    }

    @Override
    public Category getCategoryByName(String name) {
        return this.categoryRespository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRespository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(category1 -> !categoryRespository.existsByName(category1.getName()))
                .map(categoryRespository::save).orElseThrow(() -> {
                    throw new AlreadyExistException("category already exist");
                });
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {
            return Optional.ofNullable(getCategoryById(id)).map(oldCategory->{
                oldCategory.setName(category.name);
                return categoryRespository.save(oldCategory);
            }).orElseThrow(()-> new ResourceNotFoundException("category no found"));
    }

    @Override
    public void deleteCtaegoryById(Long id) {
         this.categoryRespository.findById(id).
              ifPresentOrElse(categoryRespository::delete,()->{throw  new ResourceNotFoundException("category not found  ");});

    }
}
