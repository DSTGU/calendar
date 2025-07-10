package pl.tstawowy.calendar.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pl.tstawowy.calendar.dtos.output.DayDTO;
import pl.tstawowy.calendar.enums.ViewType;

@Service
public class CalendarService {
    
    Logger logger = LoggerFactory.getLogger(CalendarService.class);

    public List<DayDTO> createDays(Calendar calendar, ViewType viewType, LocalDate date) {
        //Todo: obsługa kalendarza
        
        if (date == null) {
            date = LocalDate.now();
        }
        
        Integer year = date.getYear(); 
        Integer month = date.getMonthValue();

        LocalDate firstOfMonth = LocalDate.of(year, month, 1);
        LocalDate firstInCalendar = firstOfMonth.minusDays(firstOfMonth.getDayOfWeek().getValue() - 1);
        LocalDate lastInCalendar = firstInCalendar.plusDays(41);


        List<DayDTO> days = Stream.iterate(firstInCalendar, iDate -> iDate.plusDays(1))
            .limit(42).map(iDate -> new DayDTO(iDate, firstOfMonth.getMonth())).toList();

        logger.info("days: {} - {}", firstInCalendar, lastInCalendar);

        return days;
    }

}
