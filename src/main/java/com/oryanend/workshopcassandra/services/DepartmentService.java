package com.oryanend.workshopcassandra.services;

import com.oryanend.workshopcassandra.model.dto.DepartmentDTO;
import com.oryanend.workshopcassandra.model.entities.Department;
import com.oryanend.workshopcassandra.repositories.DepartmentRepository;
import com.oryanend.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll() {
        return repository.findAll().stream().map(DepartmentDTO::new).toList();
    }

    public DepartmentDTO findById(String id) {
        Department entity = getById(id);
        return new DepartmentDTO(entity);
    }

    private Department getById(String id) {
        Optional<Department> result = repository.findById(UUID.fromString(id));
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

    public DepartmentDTO insert(DepartmentDTO dto){
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO update(String id, DepartmentDTO dto) {
        Department entity = getById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }

}
