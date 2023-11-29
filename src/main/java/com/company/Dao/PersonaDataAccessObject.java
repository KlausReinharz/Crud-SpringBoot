/*
 En este proyecto no sera una clases sino sera una interfaces
 */
package com.company.Dao;

import com.company.doman.Personas;
import org.springframework.data.repository.CrudRepository;


public interface PersonaDataAccessObject extends CrudRepository<Personas,Long>{
    
    
}
