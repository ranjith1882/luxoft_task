package com.ark.sub.exception;

/**
 * This exception throws when co-ordinates in out of grid limits
 */
public class GridLimitException extends Exception {

    public GridLimitException(String message) {
        super(message);
    }
}
