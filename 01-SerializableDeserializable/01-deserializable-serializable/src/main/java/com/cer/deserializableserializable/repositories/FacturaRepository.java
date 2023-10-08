package com.cer.deserializableserializable.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cer.deserializableserializable.repositories.entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura,Long>{
    
}
