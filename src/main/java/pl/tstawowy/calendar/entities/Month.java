package pl.tstawowy.calendar.entities;

import java.time.LocalDate;
import java.time.format.TextStyle;
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
public class Month {
 
    java.time.Month month;
    Calendar calendar;
    LocalDate startDate;
    String name;

    public Month(LocalDate startDate) {
        this.startDate = startDate;
        month = startDate.getMonth();
    }

    public LocalDate previousMonth() {
        return startDate.minusMonths(1);
    }

    public LocalDate nextMonth() {
        return startDate.plusMonths(1);
    }

    public String getName() {
        return month.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()) + " " + startDate.getYear();
    }
}
