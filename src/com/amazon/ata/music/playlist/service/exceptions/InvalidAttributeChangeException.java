package com.amazon.ata.music.playlist.service.exceptions;

/**
 * Exception to throw when a provided attribute has an invalid change.
 */
public class InvalidAttributeChangeException extends InvalidAttributeException {

    private static final long serialVersionUID = 9046488933703120901L;

    /**
     * Exception with no message or cause.
     */
    public InvalidAttributeChangeException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public InvalidAttributeChangeException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidAttributeChangeException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidAttributeChangeException(String message, Throwable cause) {
        super(message, cause);
    }

}
