package org.talento.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SaleException extends RuntimeException {
    public SaleException() {
        super("Error en la venta");
    }
}
