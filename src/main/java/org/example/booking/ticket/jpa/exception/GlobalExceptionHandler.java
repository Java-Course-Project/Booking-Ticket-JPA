package org.example.booking.ticket.jpa.exception;

import org.example.booking.ticket.jpa.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleConflict(DataInvalidException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.builder()
                                                                            .message(ex.getMessage())
                                                                            .timestamp(Instant.now())
                                                                            .build());
    }
}
