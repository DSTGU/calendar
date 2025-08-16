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
    List<Day> days;
    LocalDate startDate;

    public Week(LocalDate startDate) {

        int dow = startDate.getDayOfWeek().getValue();
        this.startDate = startDate.minusDays(dow - 1);
    }

    public String getName() {

        if (!startDate.getMonth().equals(startDate.plusDays(6))) {
        }

        return startDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()) + " " + startDate.getYear();

    }
}
