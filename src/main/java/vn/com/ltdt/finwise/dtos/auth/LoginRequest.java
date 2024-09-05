package vn.com.ltdt.finwise.dtos.auth;

public record LoginRequest(
        String email,
        String password
) {
}
