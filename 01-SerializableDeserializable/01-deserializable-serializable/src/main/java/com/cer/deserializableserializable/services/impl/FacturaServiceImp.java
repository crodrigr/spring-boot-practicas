package com.cer.deserializableserializable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cer.deserializableserializable.repositories.FacturaRepository;
import com.cer.deserializableserializable.repositories.entities.Factura;
import com.cer.deserializableserializable.services.FacturaService;



@Service
public class FacturaServiceImp implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
       return (List<Factura>) facturaRepository.findAll();
    }
    
}
