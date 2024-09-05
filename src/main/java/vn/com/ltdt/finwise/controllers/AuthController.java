package vn.com.ltdt.finwise.controllers;

import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.ltdt.finwise.dtos.LoginRequest;
import vn.com.ltdt.finwise.dtos.RegisterRequest;
import vn.com.ltdt.finwise.dtos.Token;
import vn.com.ltdt.finwise.services.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<Token> register(@RequestBody @Valid RegisterRequest request) throws JOSEException {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("login")
    public ResponseEntity<Token> login(@RequestBody LoginRequest request) throws JOSEException {
        return ResponseEntity.ok(authService.login(request));
    }

}
