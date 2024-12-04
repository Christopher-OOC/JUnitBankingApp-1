package org.example.fx.exceptiion;

public class NotARegularUserException extends RuntimeException {

    public NotARegularUserException() {
        super("User is not a regular!");
    }

}
