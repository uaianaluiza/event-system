package com.event.system.v2.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String message){
        super(message);
    }
}
