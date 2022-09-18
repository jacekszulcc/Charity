package pl.coderslab.charity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.UserRole;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findUsersByRoles(UserRole role);
}
