package com.oryanend.workshopcassandra.repositories;

import com.oryanend.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
