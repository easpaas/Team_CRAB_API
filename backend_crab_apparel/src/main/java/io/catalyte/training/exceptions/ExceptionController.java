package io.catalyte.training.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;

import static io.catalyte.training.constants.StringConstants.*;

/**
 * A controller advice allows you to use exactly the same exception handling techniques but apply
 * them across the whole application, not just to an individual controller. You can think of them as
 * an annotation driven interceptor. More info:
 * https://www.baeldung.com/exception-handling-for-rest-with-spring
 */
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFound.class)
    protected ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFound exception) {
        ExceptionResponse response =
                new ExceptionResponse(NOT_FOUND, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceUnavailable.class)
    protected ResponseEntity<ExceptionResponse> serverError(ServiceUnavailable exception) {
        ExceptionResponse response =
                new ExceptionResponse(SERVER_ERROR, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(AlreadyExistsInDataBase.class)
    protected ResponseEntity<ExceptionResponse> resourceAlreadyExists(AlreadyExistsInDataBase exception) {
        ExceptionResponse response = new ExceptionResponse(ALREADY_EXISTS, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ExceptionResponse> validationError(DataIntegrityViolationException exception) {
        ExceptionResponse response = new ExceptionResponse(ALREADY_EXISTS, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<ExceptionResponse> idNotFound(EmptyResultDataAccessException exception) {
        ExceptionResponse response =
                new ExceptionResponse(NOT_FOUND, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ExceptionResponse> validationError(ConstraintViolationException exception) {
        ExceptionResponse response = new ExceptionResponse(INVALID_INPUT, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Unauthenticated.class)
    protected ResponseEntity<ExceptionResponse> unauthenticated(Unauthenticated exception) {
        ExceptionResponse response = new ExceptionResponse(Unauthenticated, new Date(), exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }



    private String parseMessage(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();
        for (FieldError err : errors) {
            message.append(err.getDefaultMessage());
            message.append(" ");
        }
        return message.toString().trim();

    }
}