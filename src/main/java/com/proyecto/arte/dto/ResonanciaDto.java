package com.proyecto.arte.dto;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.arte.model.TipoMaterial;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ResonanciaDto {
	 private String resonanciaId;
	 private String nombre;
	 private String disciplina;
	 private String lugar;
	 private Boolean esAnonimo;
	 private String path;
	 private TipoMaterial tipoMaterial;
	 MultipartFile file;
	    
	
	

}
