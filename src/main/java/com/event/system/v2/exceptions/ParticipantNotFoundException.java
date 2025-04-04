package com.event.system.v2.exceptions;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(String message) {
        super(message);
    }
}
