package com.cer.deserializableserializable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cer.deserializableserializable.repositories.entities.Cliente;
import com.cer.deserializableserializable.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearFactura(@RequestBody Cliente cliente) {
        Cliente clienteCreado = clienteService.save(cliente);
        return ResponseEntity.ok(clienteCreado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarFacturas() {
         List<Cliente> clientes = clienteService.findAll();
         return ResponseEntity.ok(clientes);
    }   
    
}
