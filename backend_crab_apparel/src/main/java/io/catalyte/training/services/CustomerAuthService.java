package io.catalyte.training.services;

import io.catalyte.training.security.AuthToken;
import io.catalyte.training.security.Credential;

public interface CustomerAuthService {

    AuthToken login(Credential credentials);

}
