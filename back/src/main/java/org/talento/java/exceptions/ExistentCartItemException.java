package org.talento.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExistentCartItemException extends RuntimeException {
    public ExistentCartItemException() {
        super("Este producto ya está en el carrito");
    }
}
