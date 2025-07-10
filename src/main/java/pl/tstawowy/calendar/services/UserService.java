package pl.tstawowy.calendar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.repositories.UserRepository;

public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void createUser(String login, String rawPassword) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(rawPassword)); // bcrypt!
        userRepository.save(user);
    }
}
