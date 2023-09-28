package com.amazon.ata.music.playlist.service.exceptions;

/**
 * Base Exception for provided values that are invalid.
 */
public class InvalidAttributeException extends RuntimeException {

    private final static long serialVersionUID = 4568811759984395522L;

    /**
     * Exception with no message or cause.
     */
    public InvalidAttributeException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public InvalidAttributeException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidAttributeException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidAttributeException(String message, Throwable cause) {
        super(message, cause);
    }

}
