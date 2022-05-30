package com.proyecto.arte.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * User not found exception
 * @author Roberto Crespo
 */
public class UserNotFoundException extends NestedRuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userId) {
        super(String.format("User with  Id '%s' not founded", userId));
    }

}
