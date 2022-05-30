
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
@Document(collection = "tipoMaterial")
@JsonPropertyOrder({"userId", "codigo", "descripcion"})
@Setter @Getter
public class TipoMaterial implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @NotNull  
    private String userId;
    @NotNull
    private String codigo;
    @NotNull
    private String descripcion;
    
    

}
