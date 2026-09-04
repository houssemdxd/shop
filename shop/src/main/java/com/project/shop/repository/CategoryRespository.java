package com.project.shop.repository;

import com.project.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category,Long> {
    Category findByName(String name);

    boolean existsByName(String name);
}
