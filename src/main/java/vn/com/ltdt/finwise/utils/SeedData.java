package vn.com.ltdt.finwise.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.com.ltdt.finwise.entities.Role;
import vn.com.ltdt.finwise.repositories.RoleRepository;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if(!roleRepository.existsByName("ROLE_USER")) {
            roleRepository.save(Role.builder().name("ROLE_USER").build());
        }
    }
}
