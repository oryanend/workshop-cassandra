package com.oryanend.workshopcassandra.services;

import com.oryanend.workshopcassandra.model.dto.ProductDTO;
import com.oryanend.workshopcassandra.model.entities.Product;
import com.oryanend.workshopcassandra.repositories.ProductRepository;
import com.oryanend.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(String id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(String id) {
        Optional<Product> result = repository.findById(UUID.fromString(id));
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

}
