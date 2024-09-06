package vn.com.ltdt.finwise.services;

import com.nimbusds.jose.JOSEException;
import vn.com.ltdt.finwise.dtos.auth.LoginRequest;
import vn.com.ltdt.finwise.dtos.auth.RegisterRequest;
import vn.com.ltdt.finwise.dtos.Token;

import java.util.concurrent.CompletableFuture;

public interface AuthService {
    Token register(RegisterRequest request) throws JOSEException;
    Token login(LoginRequest request) throws JOSEException;
    void verifyUser(String userId);
}
