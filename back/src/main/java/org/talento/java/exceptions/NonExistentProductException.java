package org.talento.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NonExistentProductException extends RuntimeException {
    public NonExistentProductException() {
        super("Producto inexistente");
    }
}
