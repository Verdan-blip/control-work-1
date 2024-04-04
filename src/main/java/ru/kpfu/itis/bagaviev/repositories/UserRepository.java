package ru.kpfu.itis.bagaviev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.bagaviev.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    User findOneByEmailAndPassword(String email, String password);
}
