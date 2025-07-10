package pl.tstawowy.calendar.dtos.output;

import java.time.LocalDate;
import java.time.Month;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DayDTO {

    LocalDate date;
    String textColor;


    public DayDTO(LocalDate date, Month month) {
        this.date = date;
        if (date.getMonth().equals(month)) {
            textColor = "text-dark";
        } else {
            textColor = "text-muted";
        }
    }
}
