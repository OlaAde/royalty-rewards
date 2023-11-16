package org.example.royaltyrewards.exceptions;

public class InvalidPayloadException extends Exception {

    public InvalidPayloadException() {
        super("Invalid request body");
    }

    public InvalidPayloadException(String message) {
        super(message);
    }
}
