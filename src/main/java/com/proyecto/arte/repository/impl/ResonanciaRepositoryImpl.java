package com.proyecto.arte.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.arte.model.Resonancia;
import com.proyecto.arte.model.User;
import com.proyecto.arte.repository.ResonanciaRepository;

/**
 * @author Roberto Crespo
 */
@Repository
public class ResonanciaRepositoryImpl implements ResonanciaRepository{

    private final MongoOperations mongoOperations;

    @Autowired
    public ResonanciaRepositoryImpl(MongoOperations mongoOperations) {
        
        this.mongoOperations = mongoOperations;
    }
    
    //Find all users
    public Optional<List<Resonancia>> findAll() {
    	List<Resonancia> resonancias = this.mongoOperations.find(new Query(), Resonancia.class);
        Optional<List<Resonancia>> optionalResonancias = Optional.ofNullable(resonancias);
        return optionalResonancias;
	}    

    public Optional<Resonancia> findOne(String resonanciaId) {
    	Resonancia d = this.mongoOperations.findOne(new Query(Criteria.where("resonanciaId").is(resonanciaId)), Resonancia.class);
        Optional<Resonancia> resonancia = Optional.ofNullable(d);
        return resonancia;
    }

    public Resonancia saveResonancia(Resonancia resonancia) {
        this.mongoOperations.save(resonancia);
        return findOne(resonancia.getResonanciaId()).get();
    }
    
    public void updateResonancia(Resonancia resonancia) {
        this.mongoOperations.save(resonancia);
    }

    public void deleteResonancia(String resonanciaId) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("resonanciaId").is(resonanciaId)), Resonancia.class);
    }
}
