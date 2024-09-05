package vn.com.ltdt.finwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.ltdt.finwise.entities.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
