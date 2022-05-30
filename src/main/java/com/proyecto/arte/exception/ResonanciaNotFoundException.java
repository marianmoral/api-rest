package com.proyecto.arte.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * User not found exception
 * @author Roberto Crespo
 */
public class ResonanciaNotFoundException extends NestedRuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResonanciaNotFoundException(String resonanciaId) {
        super(String.format("Resonancia with  Id '%s' not founded", resonanciaId));
    }

}
