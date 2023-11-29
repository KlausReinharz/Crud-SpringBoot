
package com.company.service;

import com.company.Dao.PersonaDataAccessObject;
import com.company.doman.Personas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class PersonaServiceImplementacion implements PersonaService{
    @Autowired
    private PersonaDataAccessObject personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Personas> listarPersonas() {
        return (List<Personas>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Personas personas) {
        personaDao.save(personas);
    }

    @Override
    @Transactional()
    public void eliminar(Personas personas) {
        personaDao.delete(personas);
    }

  
    @Override
    @Transactional(readOnly = true)
    public Personas encontrarPersona(Personas personas) {
       return personaDao.findById(personas.getIdPersona()).orElse(null);
    
    }
}
