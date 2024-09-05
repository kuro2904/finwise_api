package vn.com.ltdt.finwise.services.impl;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.ltdt.finwise.dtos.LoginRequest;
import vn.com.ltdt.finwise.dtos.RegisterRequest;
import vn.com.ltdt.finwise.dtos.Token;
import vn.com.ltdt.finwise.entities.AppUser;
import vn.com.ltdt.finwise.entities.Role;
import vn.com.ltdt.finwise.repositories.RoleRepository;
import vn.com.ltdt.finwise.repositories.UserRepository;
import vn.com.ltdt.finwise.security.JwtProvider;
import vn.com.ltdt.finwise.services.AuthService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public Token register(RegisterRequest request) throws JOSEException {
        if(userRepository.existsByEmail(request.email()) || userRepository.existsByPhoneNumber(request.phoneNumber())) {
            throw new RuntimeException("Email or Phone number already in use");
        }
        log.info("AppUser registered {}", request);
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("ROLE_USER");
        roles.add(role);
        AppUser appUser = AppUser.builder()
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .password(passwordEncoder.encode(request.password()))
                .fullName(request.fullName())
                .isEnabled(false)
                .roles(roles)
                .dateOfBirth(LocalDate.parse(request.dateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .build();
        userRepository.save(appUser);
        return new Token(
                "bearer ",
                jwtProvider.generateToken(appUser)
        );
    }

    @Override
    public Token login(LoginRequest request) throws JOSEException {
        return null;
    }
}
