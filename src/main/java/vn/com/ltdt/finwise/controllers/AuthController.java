package vn.com.ltdt.finwise.controllers;

import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.com.ltdt.finwise.dtos.auth.LoginRequest;
import vn.com.ltdt.finwise.dtos.auth.RegisterRequest;
import vn.com.ltdt.finwise.dtos.Token;
import vn.com.ltdt.finwise.services.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<Token> register(@RequestBody @Valid RegisterRequest request) throws JOSEException {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<Token> login(@RequestBody LoginRequest request) throws JOSEException {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("verify/{userId}")
    public ResponseEntity<String> verify(@PathVariable("userId") String userId) {
        authService.verifyUser(userId);
        return ResponseEntity.ok("Account activated");
    }

}
