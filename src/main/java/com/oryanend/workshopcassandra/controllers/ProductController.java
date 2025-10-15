package com.oryanend.workshopcassandra.controllers;

import com.oryanend.workshopcassandra.model.dto.ProductDTO;
import com.oryanend.workshopcassandra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
