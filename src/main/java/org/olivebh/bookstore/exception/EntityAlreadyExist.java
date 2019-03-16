package org.olivebh.bookstore.exception;

public class EntityAlreadyExist extends RuntimeException {
    public EntityAlreadyExist(String message) {
        super(message);
    }

    public EntityAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExist(Throwable cause) {
        super(cause);
    }
}
