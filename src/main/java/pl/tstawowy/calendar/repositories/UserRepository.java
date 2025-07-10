package pl.tstawowy.calendar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tstawowy.calendar.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
