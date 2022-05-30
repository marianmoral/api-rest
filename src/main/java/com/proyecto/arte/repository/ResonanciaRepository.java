package com.proyecto.arte.repository;

import java.util.List;
import java.util.Optional;

import com.proyecto.arte.model.Resonancia;
import com.proyecto.arte.model.User;

/**
 * Crud repository interface
 * @author mmoral
 * @since 1.0.0
 */
public interface ResonanciaRepository{

       
   /**
    * Find a resonancias list     
    * @return
    */
  Optional<List<Resonancia>> findAll();

    /**
     * Find a resonancia
     * @param resonanciaId
     * @return
     */
    public Optional<Resonancia> findOne(String resonanciaId);

    /**
     * save a new resonancia
     * @param resonancia
     * @return
     */
    public Resonancia saveResonancia(Resonancia resonancia);

    /**
     * Update a resonancia
     * @param resonancia
     */
    public void updateResonancia(Resonancia resonancia);

    /**
     * Delete a resonancia by id
     * @param resonanciaId
     */
    public void deleteResonancia(String resonanciaId);

}
