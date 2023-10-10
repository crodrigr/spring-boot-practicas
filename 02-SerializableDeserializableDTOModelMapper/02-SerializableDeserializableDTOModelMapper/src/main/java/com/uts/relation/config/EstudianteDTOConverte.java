package com.uts.relation.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uts.relation.dto.EstudianteDTO;
import com.uts.relation.dto.MatriculaDTO;
import com.uts.relation.dto.UniversidadDTO;
import com.uts.relation.repositories.entities.EstudianteEntity;
import com.uts.relation.repositories.entities.MatriculaEntity;
import com.uts.relation.repositories.entities.UniversidadEntity;

@Component
public class EstudianteDTOConverte {

    @Autowired
       private ModelMapper dbm;

    public EstudianteDTO converEstudianteDTO(EstudianteEntity estudiante){

           
                /*EstudianteDTO estudianteDTO=new EstudianteDTO();                
                estudianteDTO.setId(estudiante.getId());
                estudianteDTO.setNombre(estudiante.getNombre());
                UniversidadDTO universidadDTO=new UniversidadDTO();
                UniversidadEntity universidadEntity=estudiante.getUniversidad();
                universidadDTO.setId(universidadEntity.getId());
                universidadDTO.setNombre(universidadEntity.getNombre());
                estudianteDTO.setUniversidad(universidadDTO);
                if(estudiante.getMatricula()!=null){
                MatriculaEntity matriculaEntity=estudiante.getMatricula();
                MatriculaDTO matriculaDTO=new MatriculaDTO();
                matriculaDTO.setId(matriculaEntity.getId());
                matriculaDTO.setFeed(matriculaEntity.getFeed());
                estudianteDTO.setMatricula(matriculaDTO);
                }*/
                EstudianteDTO estudianteDTO=dbm.map(estudiante,EstudianteDTO.class);
                if(estudiante.getMatricula()!=null){
                  estudianteDTO.setMatriculaId(estudiante.getMatricula().getId());
                }
                estudianteDTO.setUniversidadId(estudiante.getUniversidad().getId());

                return estudianteDTO;
                
    

    }

    public EstudianteEntity converEstudianteEntity(EstudianteDTO estudianteDTO){
          return dbm.map(estudianteDTO,EstudianteEntity.class);
          
    }
    
}
