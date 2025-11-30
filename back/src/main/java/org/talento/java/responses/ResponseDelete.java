package org.talento.java.responses;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

public record ResponseDelete(
    OffsetDateTime timestamp,
    int status,
    String message,
    String path
) {
    public static ResponseEntity<ResponseDelete> of(HttpServletRequest request, String message) {
        var response = new ResponseDelete(OffsetDateTime.now(),200,message,request.getRequestURI());
        return ResponseEntity.ok(response);
    }
}
