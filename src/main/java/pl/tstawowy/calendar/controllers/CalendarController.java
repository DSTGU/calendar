package pl.tstawowy.calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalendarController {
    
    @GetMapping("/")
    public String landingPage() {
        return "main";
    }
    
}
