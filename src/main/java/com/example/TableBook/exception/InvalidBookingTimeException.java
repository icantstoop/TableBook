package com.example.TableBook.exception;

public class InvalidBookingTimeException extends RuntimeException {
    public InvalidBookingTimeException(String message) {
        super(message);
    }
}
