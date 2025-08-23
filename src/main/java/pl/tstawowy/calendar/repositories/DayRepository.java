package pl.tstawowy.calendar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tstawowy.calendar.entities.Calendar;
import pl.tstawowy.calendar.entities.Day;
import pl.tstawowy.calendar.entities.User;

import java.util.Collection;
import java.util.List;


public interface DayRepository extends JpaRepository<Day, Long> {
    List<Day> findByCalendar(Calendar calendar);
    List<Day> findByCalendarIn(Collection<Calendar> calendars);

    List<Day> findByCalendarUser(User user);
}
