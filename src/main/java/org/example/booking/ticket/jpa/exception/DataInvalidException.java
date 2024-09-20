package org.example.booking.ticket.jpa.exception;

public class DataInvalidException extends RuntimeException {

    public DataInvalidException(String message) {
        super(message);
    }
}
