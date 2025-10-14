package com.oryanend.workshopcassandra.controllers;

import com.oryanend.workshopcassandra.model.dto.DepartmentDTO;
import com.oryanend.workshopcassandra.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable String id) {
        DepartmentDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
