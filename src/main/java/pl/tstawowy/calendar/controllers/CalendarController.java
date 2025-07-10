package pl.tstawowy.calendar.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.repositories.UserRepository;
import pl.tstawowy.calendar.services.UserService;


@Controller
public class CalendarController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        Optional<User> user = userRepository.findByLogin(principal.getName());
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
    }

    @GetMapping("/")
    public String landingPage() {
        return "main";
    }
    
}
