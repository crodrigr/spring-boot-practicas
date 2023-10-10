package com.uts.relation.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uts.relation.config.EstudianteDTOConverte;
import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.repositories.EstudianteRepository;
import com.uts.relation.repositories.entities.EstudianteEntity;
import com.uts.relation.services.EstudianteService;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteDTOConverte convert;

    @Override
    @Transactional
    public List<EstudianteDTO> findAll() {
        List<EstudianteEntity> estudiantesEntity = (List<EstudianteEntity>) estudianteRepository.findAll();

        return estudiantesEntity.stream()
                .map(estudiante -> convert.converEstudianteDTO(estudiante))
                .toList();

    }

}
