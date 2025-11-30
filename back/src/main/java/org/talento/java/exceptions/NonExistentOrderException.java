package org.talento.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NonExistentOrderException extends RuntimeException {
    public NonExistentOrderException() {
        super("Orden inexistente");
    }
}
