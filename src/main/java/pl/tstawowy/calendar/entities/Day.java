package pl.tstawowy.calendar.entities;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    Calendar calendar;
    LocalDate date;
    String color;

    public Day(LocalDate date) {
        this.date = date;
    }

    public LocalDate getPreviousDay() {
        return date.minusDays(1);
    }

    public LocalDate getNextDay() {
        return date.plusDays(1);
    }

    //TODO: fix (31 lipiec lmao)
    public String getName() {
        return date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()) + " " + date.getYear();
    }
}
