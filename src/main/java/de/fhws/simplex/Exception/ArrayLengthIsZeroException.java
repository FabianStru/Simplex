package de.fhws.simplex.Exception;

public class ArrayLengthIsZeroException extends Exception{
    public ArrayLengthIsZeroException() {
    }

    public ArrayLengthIsZeroException(String message) {
        super(message);
    }

    public ArrayLengthIsZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayLengthIsZeroException(Throwable cause) {
        super(cause);
    }

    public ArrayLengthIsZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
