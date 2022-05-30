package com.proyecto.arte.service;

import java.util.List;

import com.proyecto.arte.model.Resonancia;



/**
 * This class has the neccesary methods to implement a CRUD
 * @author mmoral
 * @since 1.0.0
 */
public interface ResonanciaService {

	/**
    * Find all resonancias
    * @return controller
    */
   List<Resonancia> findAll();
	
	/**
     * Find a controller
     * @param resonanciaId
     * @return controller
     */
    Resonancia findByUserId(String ResonanciaId);

  
    /**
     * Save a new resonancia
     * @param resonancia
     * @return controller saved
     */
    Resonancia saveResonancia(Resonancia resonancia);

    /**
     * Update a resonancia
     * @param resonancia
     */
    void updateResonancia(Resonancia resonancia);

    /**
     * Delete a resonancia
     * @param resonanciaId
     */
    void deleteResonancia(String resonanciaId);
}
