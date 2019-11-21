package io.catalyte.training.exceptions;

public class ServiceUnavailable extends RuntimeException {

    public ServiceUnavailable() {}

    public ServiceUnavailable(String message) {super(message);}
}

