package pl.tstawowy.calendar.entities;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

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
    Month month;
    List<Day> days;
    LocalDate startDate;

    public Week(LocalDate startDate) {
        int dow = startDate.getDayOfWeek().getValue();
        this.startDate = startDate.minusDays(dow - 1);
    }

    public Week(LocalDate startDate, Month month) {
        int dow = startDate.getDayOfWeek().getValue();
        this.startDate = startDate.minusDays(dow - 1);

        this.month = month;
    }

    public String getName() {

        if (!startDate.getMonth().equals(startDate.plusDays(6))) {
        }

        return startDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()) + " " + startDate.getYear();

    }

    public LocalDate previousWeek() {
        return startDate.minusDays(7);
    }

    public LocalDate nextWeek() {
        return startDate.plusDays(7);
    }
}
