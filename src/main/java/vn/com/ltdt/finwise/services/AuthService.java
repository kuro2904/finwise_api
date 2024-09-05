package vn.com.ltdt.finwise.services;

import com.nimbusds.jose.JOSEException;
import vn.com.ltdt.finwise.dtos.LoginRequest;
import vn.com.ltdt.finwise.dtos.RegisterRequest;
import vn.com.ltdt.finwise.dtos.Token;

public interface AuthService {
    Token register(RegisterRequest request) throws JOSEException;
    Token login(LoginRequest request) throws JOSEException;
}
