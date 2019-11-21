package io.catalyte.training.constants;

public class StringConstants {

    // General
    public static final String NOT_FOUND = "Not Found";
    public static final String Unauthenticated = "Unauthenticated";
    public static final String CONFLICT = "Conflict";
    public static final String UNAUTHORIZED = "Unauthorized";
    public static final String SERVER_ERROR = "Server Error";
    public static final String SERVER_ERROR_MESSAGE = "An unexpected error occurred.";
    public static final String ERROR_LOG = "Error: ";
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String EMPLOYEE_ROLE = "EMPLOYEE";
    public static final String REQUIRED_FIELD = " is a required field.";
    public static final String EMAIL_INVALID = "Email should be a well-formed email address.";
    public static final String INVALID_NUMBER = " must be greater than or equal to 0.";
    public static final String INVALID_POSITIVE = "A positive value is required for this field";
    public static final String ID_NOT_FOUND =  "You attempted an operation on an id that does not exist in the database";
    public static final String ALREADY_EXISTS = "You have attempted to add a duplicate field of a unique Table column";
    public static final String INVALID_INPUT = "You have entered an invalid format for this field";

    // Auth
    public static final String INVALID_EMAIL_PASSWORD = "Invalid email or password.";
    public static final String ISSUER = "gcapi";
    public static final String SECRET_KEY = "secret";
    public static final String CLAIMS_ATTRIBUTE = "claims";
    public static final String ROLES_ATTRIBUTE = "roles";
    public static final String ADMIN_ROLE_TYPE = "ADMIN";
    public static final String EMPLOYEE_ROLE_TYPE = "EMPLOYEE";
    public static final String CUSTOMER_ROLE_TYPE = "CUSTOMER";
    public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String MISSING_INVALID_ERROR = "Missing or invalid Authorization header";
}