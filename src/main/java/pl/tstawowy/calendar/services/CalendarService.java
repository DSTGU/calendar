package pl.tstawowy.calendar.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.tstawowy.calendar.dtos.output.DayDTO;
import pl.tstawowy.calendar.dtos.output.WeekDTO;
import pl.tstawowy.calendar.entities.Calendar;
import pl.tstawowy.calendar.entities.User;
import pl.tstawowy.calendar.enums.ViewType;
import pl.tstawowy.calendar.repositories.CalendarRepository;

@Service
public class CalendarService {
    
    Logger logger = LoggerFactory.getLogger(CalendarService.class);

    @Autowired
    CalendarRepository calendarRepo;

    public List<Calendar> getCalendars(User user) {
        return calendarRepo.findByUser(user);
    }


    public List<WeekDTO> createWeeks(Calendar calendar, ViewType viewType, LocalDate date) {
        //Todo: obsługa kalendarza
        
        if (date == null) {
            date = LocalDate.now();
        }
        
        Integer year = date.getYear(); 
        Integer month = date.getMonthValue();

        LocalDate firstOfMonth = LocalDate.of(year, month, 1);
        LocalDate firstInCalendar = firstOfMonth.minusDays(firstOfMonth.getDayOfWeek().getValue() - 1);

        
        List<WeekDTO> weeks = Stream.iterate(firstInCalendar, iDate -> iDate.plusDays(7)).limit(6).map(iDate -> new WeekDTO(iDate)).toList();
        weeks.stream().forEach(w -> w.setDays(Stream.iterate(w.getStartDate(), jDate -> jDate.plusDays(1)).limit(7).map(day -> new DayDTO(day, firstOfMonth.getMonth())).toList()));
        
        return weeks;
    }
    
    public List<DayDTO> createDays(Calendar calendar, ViewType viewType, LocalDate date) {
        
        if (date == null) {
            date = LocalDate.now();
        }

        int dow = date.getDayOfWeek().getValue();
        LocalDate firstDay = date.minusDays(dow - 1);
        
        List<DayDTO> days = Stream.iterate(firstDay, iDate -> iDate.plusDays(1))
        .limit(7).map(iDate -> new DayDTO(iDate, firstDay.getMonth())).toList();
        
        return days;
    }
    
}
