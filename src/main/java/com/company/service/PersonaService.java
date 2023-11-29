
package com.company.service;

import com.company.doman.Personas;
import java.util.List;

/**
 *
 * @author ALEXANDER
 */
public interface PersonaService {
    public List<Personas>listarPersonas();
    
    public void guardar(Personas personas);
    public void eliminar(Personas personas);
    public Personas encontrarPersona(Personas personas);
    
}
