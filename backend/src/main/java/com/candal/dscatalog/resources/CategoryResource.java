package com.candal.dscatalog.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candal.dscatalog.entities.Category;
import com.candal.dscatalog.services.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService service;

    CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
}
