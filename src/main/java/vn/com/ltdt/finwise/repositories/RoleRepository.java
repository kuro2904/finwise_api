package vn.com.ltdt.finwise.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.com.ltdt.finwise.entities.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
    boolean existsByName(String name);
}
