package io.catalyte.training.exceptions;

public class AlreadyExistsInDataBase extends RuntimeException {

    public AlreadyExistsInDataBase() {}

    public AlreadyExistsInDataBase(String message) {super(message);}
}