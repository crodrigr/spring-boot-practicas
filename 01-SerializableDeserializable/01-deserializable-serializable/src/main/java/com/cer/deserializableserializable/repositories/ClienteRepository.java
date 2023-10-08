package com.cer.deserializableserializable.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cer.deserializableserializable.repositories.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {
    
}
