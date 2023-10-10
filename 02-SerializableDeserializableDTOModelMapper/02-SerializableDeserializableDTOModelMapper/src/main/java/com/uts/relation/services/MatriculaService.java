package com.uts.relation.services;

import java.util.List;

import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.repositories.entities.MatriculaEntity;

public interface MatriculaService {

    MatriculaDTO save(Long estudianteId,MatriculaEntity matricula);

    List<MatriculaEntity> findAll();
    
}
