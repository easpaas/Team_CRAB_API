package io.catalyte.training.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.catalyte.training.domains.customers.Customer;
import io.catalyte.training.exceptions.Unauthenticated;
import io.catalyte.training.security.AuthToken;
import io.catalyte.training.security.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static io.catalyte.training.constants.StringConstants.*;
import static io.catalyte.training.constants.StringConstants.ROLES_ATTRIBUTE;
import static java.util.regex.Pattern.matches;

@Service
public class CustomerAuthServiceImpl implements CustomerAuthService {

    private final CustomerService customerService;

    @Autowired
    public CustomerAuthServiceImpl(CustomerService userService) {
        this.customerService = userService;
    }

    @Override
    public AuthToken login(Credential credentials) {
        if(credentials.getEmail() == null || credentials.getPassword() == null) {
            throw new Unauthenticated(INVALID_EMAIL_PASSWORD);
        }

        String email = credentials.getEmail();
        String password = credentials.getPassword();

        Customer customer = customerService.getCustomerByEmail(email);

        if(customer == null) {
            throw new Unauthenticated(INVALID_EMAIL_PASSWORD);
        }

        String passwordOnFile = customer.getPassword();

        if(!matches(password, passwordOnFile)) {
            throw new Unauthenticated(INVALID_EMAIL_PASSWORD);
        }

        String userRole = CUSTOMER_ROLE_TYPE;

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String jwtToken = JWT.create().withIssuer(ISSUER).withClaim(ROLES_ATTRIBUTE, userRole)
                .withSubject(email).withIssuedAt(new Date()).sign(algorithm);

        return new AuthToken(jwtToken);
    }

}
