package com.uts.relation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.repositories.entities.MatriculaEntity;
import com.uts.relation.services.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
      
      @Autowired
      private MatriculaService matriculaService;

      @PostMapping("/{id}")
      public MatriculaDTO save(@PathVariable Long id, @RequestBody MatriculaEntity matricula){
           return matriculaService.save(id,matricula);

      }


      @GetMapping("/")
      public List<MatriculaEntity> findAll(){
         return matriculaService.findAll();
      }

    
}
