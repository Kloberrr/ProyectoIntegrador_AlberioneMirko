package com.portfolio.mta.Interface;

import com.portfolio.mta.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Parra traer una lista de Personas
    public List<Persona> getPersona();
    
    //Guardar un objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona (Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
