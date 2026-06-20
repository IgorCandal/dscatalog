package com.candal.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candal.dscatalog.dto.CategoryDTO;
import com.candal.dscatalog.entities.Category;
import com.candal.dscatalog.exceptions.EntityNotFoundExceptions;
import com.candal.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();

        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
     }

     @Transactional(readOnly = true)
     public CategoryDTO findById(Long id){
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundExceptions("Entity not found"));
        return new CategoryDTO(entity);
     }

     @Transactional
     public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
        
    }

    
}
