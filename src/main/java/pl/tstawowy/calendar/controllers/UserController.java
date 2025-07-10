package pl.tstawowy.calendar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import pl.tstawowy.calendar.dtos.input.UserRegisterDTO;
import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.repositories.UserRepository;
import pl.tstawowy.calendar.services.UserService;



@Controller
public class UserController {
    
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model) {

        if (!model.containsAttribute("user"))
        {
            UserRegisterDTO user = new UserRegisterDTO();
            model.addAttribute("user", user);
        }
        return "user/register";
    }



    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        
        
        logger.info("DTO: {}", userRegisterDTO);
        logger.info("BR: {}", bindingResult);

        if (userRegisterDTO.getPassword() == null || !userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
            bindingResult.addError(new FieldError("user", "repeatPassword", "Hasła muszą być jednakowe"));
        }

        if (userService.userExists(userRegisterDTO.getLogin())) {
            bindingResult.addError(new FieldError("user", "login", "Użytkownik istnieje"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            return "redirect:/register";
        }

        User user = userService.createUser(userRegisterDTO.getLogin(), userRegisterDTO.getPassword());
        userRepository.save(user);


        return "redirect:/login";
    }
}
