package com.terekhin.exceptions;

/**
 * Created by Nick on 09.11.17.
 */
public class DBException extends Exception {
    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}
