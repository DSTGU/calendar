package pl.tstawowy.calendar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User createUser(String login, String rawPassword) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(rawPassword)); // bcrypt!
        return user;
    }

    public boolean userExists(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

}
