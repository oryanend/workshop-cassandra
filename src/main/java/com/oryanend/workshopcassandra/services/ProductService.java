package com.oryanend.workshopcassandra.services;

import com.oryanend.workshopcassandra.model.dto.ProductDTO;
import com.oryanend.workshopcassandra.model.entities.Product;
import com.oryanend.workshopcassandra.repositories.ProductRepository;
import com.oryanend.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<ProductDTO> findByDepartment(String department) {
        List<Product> list;
        if ("".equals(department)) {
            list = repository.findAll();
        } else {
            list = repository.findByDepartment(department);
        }
        return list.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> findByDescription(String text) {
        List<Product> list;
        if ("".equals(text)) {
            list = repository.findAll();
            return list.stream().map(ProductDTO::new).toList();
        }
        list = repository.findByDescription("%"+text+"%");
        return list.stream().map(ProductDTO::new).toList();
    }

}
