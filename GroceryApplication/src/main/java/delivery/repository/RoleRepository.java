package delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import delivery.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
