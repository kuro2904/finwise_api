package vn.com.ltdt.finwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.ltdt.finwise.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
