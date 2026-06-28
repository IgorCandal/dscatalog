package com.candal.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.candal.dscatalog.entities.Category;
import com.candal.dscatalog.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Instant date;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(){}

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public ProductDTO(Product entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
        this.date = entity.getDate();
    }

    public ProductDTO(Product entity, Set<Category> categories){
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
    public Instant getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public Long getId() {
        return id;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
    public void setDate(Instant date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
