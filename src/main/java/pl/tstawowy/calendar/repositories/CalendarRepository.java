package pl.tstawowy.calendar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tstawowy.calendar.entities.Calendar;
import pl.tstawowy.calendar.entities.User;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUser(User user);
}
