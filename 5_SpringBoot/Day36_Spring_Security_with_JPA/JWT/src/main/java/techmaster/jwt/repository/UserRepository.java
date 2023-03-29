package techmaster.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techmaster.jwt.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}