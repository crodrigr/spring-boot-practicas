package com.cer.deserializableserializable.services;

import java.util.List;

import com.cer.deserializableserializable.repositories.entities.Cliente;


public interface ClienteService {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();
    
}
