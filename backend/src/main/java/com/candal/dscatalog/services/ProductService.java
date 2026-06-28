package com.candal.dscatalog.services;

import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candal.dscatalog.dto.ProductDTO;
import com.candal.dscatalog.entities.Product;
import com.candal.dscatalog.exceptions.DataBaseException;
import com.candal.dscatalog.exceptions.EntityNotFoundExceptions;
import com.candal.dscatalog.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable){
        Page<Product> list = repository.findAll(pageable);

        return list.map(x -> new ProductDTO(x));
     }

     @Transactional(readOnly = true)
     public ProductDTO findById(Long id){
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new EntityNotFoundExceptions("Entity not found"));
        return new ProductDTO(entity, entity.getCategories());
     }

     @Transactional
     public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        //entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ProductDTO(entity);
        
    }

    @Transactional
     public ProductDTO update(Long id, ProductDTO dto) {
        try{
            Product entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            //entity = repository.save(entity);
            return new ProductDTO(entity);
        } 
        catch (EntityNotFoundException e){
            throw new EntityNotFoundExceptions("Id not Found " + id);
        }
    }

    @Transactional
     public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new EntityNotFoundExceptions("Id not Found " + id);
        }
        try{
            repository.deleteById(id);
            repository.flush();
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation");
        }
    }

}
