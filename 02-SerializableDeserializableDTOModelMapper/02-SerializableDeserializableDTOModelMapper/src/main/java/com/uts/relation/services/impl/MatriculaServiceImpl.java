package com.uts.relation.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uts.relation.config.EstudianteDTOConverte;
import com.uts.relation.config.MatriculaDTOConverte;
import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.repositories.EstudianteRepository;
import com.uts.relation.repositories.MatriculaRepository;
import com.uts.relation.repositories.entities.EstudianteEntity;
import com.uts.relation.repositories.entities.MatriculaEntity;
import com.uts.relation.services.MatriculaService;



@Service
public class MatriculaServiceImpl implements MatriculaService {
    
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired EstudianteRepository estudianteRepository;

   @Autowired
    private MatriculaDTOConverte convert;

    

    @Override
    @Transactional
    public MatriculaDTO save(Long estudianteId,MatriculaEntity matricula) {

        Optional<EstudianteEntity> estuidanteOpintal= estudianteRepository.findById(estudianteId);       

        if(estuidanteOpintal.isPresent()){
           matricula.setEstudiante(estuidanteOpintal.get());
           matriculaRepository.save(matricula); 
           return convert.converMatriculaDTO(matricula);
                  
           
        }
        return null;        
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatriculaEntity> findAll() {
       return  (List<MatriculaEntity>) matriculaRepository.findAll();
    }
    
}
