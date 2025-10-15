package com.oryanend.workshopcassandra.controllers;

import com.oryanend.workshopcassandra.model.dto.ProductDTO;
import com.oryanend.workshopcassandra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findByDepartment(@RequestParam(name = "department", defaultValue = "") String department) {
        List<ProductDTO> list = service.findByDepartment(department);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(@RequestParam(name = "text", defaultValue = "") String text) {
        List<ProductDTO> list = service.findByDescription(text);
        return ResponseEntity.ok().body(list);
    }

}
