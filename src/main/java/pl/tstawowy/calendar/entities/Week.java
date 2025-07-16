package pl.tstawowy.calendar.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Week {
 
    Calendar calendar;
    List<Day> days;
    LocalDate startDate;

    public Week(LocalDate startDate) {
        this.startDate = startDate;
    }
}
