package com.cer.deserializableserializable.services;

import java.util.List;

import com.cer.deserializableserializable.repositories.entities.Factura;

public interface FacturaService {

    Factura save(Factura factura);

    List<Factura> findAll();
    
}
