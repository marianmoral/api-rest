package com.proyecto.arte.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.arte.exception.ResonanciaNotFoundException;
import com.proyecto.arte.model.Resonancia;
import com.proyecto.arte.model.User;
import com.proyecto.arte.repository.ResonanciaRepository;
import com.proyecto.arte.service.ResonanciaService;


/**
 * Implement ResonanciaService
 * @author mmoral
 * @since 1.0.0
 */
@Service("ResonanciaService")
@Transactional
public class ResonanciaServiceImpl implements ResonanciaService {

	private static final Log log = LogFactory.getLog(ResonanciaServiceImpl.class);
	
	private ResonanciaRepository resonanciaRepository;

    @Autowired
    public ResonanciaServiceImpl(ResonanciaRepository resonanciaRepository){
        this.resonanciaRepository = resonanciaRepository;
    }


    public Resonancia findByUserId(String resonanciaId) {
        Optional<Resonancia> resonancia = resonanciaRepository.findOne(resonanciaId);
        if (resonancia.isPresent()) {
            log.debug(String.format("Read resonanciaId '{}'", resonanciaId));
            return resonancia.get();
        }else
            throw new ResonanciaNotFoundException(resonanciaId);
    }

   
    public List<Resonancia> findAll() {
        Optional<List<Resonancia>> resonancia = resonanciaRepository.findAll();
        return resonancia.get();      
    }
    
   
    public Resonancia saveResonancia(Resonancia resonancia) {
        return resonanciaRepository.saveResonancia(resonancia);
    }

 
    public void updateResonancia(Resonancia resonancia) {
    	resonanciaRepository.updateResonancia(resonancia);
    }

    
    public void deleteResonancia(String resonanciaId) {
    	resonanciaRepository.deleteResonancia(resonanciaId);
    }

}
