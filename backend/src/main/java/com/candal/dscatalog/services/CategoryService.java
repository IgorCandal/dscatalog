package com.candal.dscatalog.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.candal.dscatalog.entities.Category;
import com.candal.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
     }
    
}
