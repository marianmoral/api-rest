package com.proyecto.arte.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class of controller
 * @author mmoral
 *
 */
@Document(collection = "resonancia")
@JsonPropertyOrder({"resonanciaId", "disciplina", "nombre","esAnonimo", "lugar", "tipoMaterial", "path"})
@Setter @Getter
public class Resonancia implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    private String resonanciaId;
    private String nombre;
    private String disciplina;
    private String lugar;
    private Boolean esAnonimo;
    private String path;
    private String tipoMaterial;
    
    
	
}
