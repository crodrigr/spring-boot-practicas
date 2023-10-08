package com.cer.deserializableserializable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cer.deserializableserializable.repositories.entities.Factura;
import com.cer.deserializableserializable.services.FacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/crear")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura facturaCreada = facturaService.save(factura);
        return ResponseEntity.ok(facturaCreada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listarFacturas() {
         List<Factura> facturas = facturaService.findAll();
         return ResponseEntity.ok(facturas);
    }   
    
}
