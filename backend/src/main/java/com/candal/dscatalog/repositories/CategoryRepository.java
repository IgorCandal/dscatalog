package com.candal.dscatalog.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.candal.dscatalog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
