package pl.tstawowy.calendar.controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pl.tstawowy.calendar.entities.Month;
import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.entities.Week;
import pl.tstawowy.calendar.enums.ViewType;
import pl.tstawowy.calendar.repositories.UserRepository;
import pl.tstawowy.calendar.services.CalendarService;
import pl.tstawowy.calendar.services.UserService;


@Controller
public class CalendarController {
    
    final Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    CalendarService calendarService;

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        Optional<User> user = userRepository.findByLogin(principal.getName());
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
    }

    @GetMapping("/")
    public String landingPage(Model model, @RequestParam(required = false) LocalDate date) {
        return "main";
    }

    @GetMapping("/ajax/calendar")
    public String getMethodName(Model model, @RequestParam(required = false) LocalDate date, @RequestParam(defaultValue = "MONTH")ViewType viewType) {

        logger.info("VT: {}", viewType);

        switch (viewType) {
            case ViewType.WEEK:
                model.addAttribute("week", new Week(date));
                model.addAttribute("days", calendarService.createDays(null, viewType, date));
                return "fragments/calendar :: week";
            default:
                model.addAttribute("month", new Month(date));
                model.addAttribute("weeks", calendarService.createWeeks(null, viewType, date));
                return "fragments/calendar :: month";
        }
        
        

    }
    
    
}
