package io.catalyte.training.exceptions;

public class Unauthenticated extends RuntimeException{
    public Unauthenticated() {}

    public Unauthenticated(String message) {
        super(message);
    }
}
