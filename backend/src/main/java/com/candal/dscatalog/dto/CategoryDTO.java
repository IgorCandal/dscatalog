package com.candal.dscatalog.dto;

import com.candal.dscatalog.entities.Category;

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(){}

    public CategoryDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
