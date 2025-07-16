package pl.tstawowy.calendar.dtos.output;

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
public class WeekDTO {
 
    List<DayDTO> days;
    LocalDate startDate;

    public WeekDTO(LocalDate startDate) {
        this.startDate = startDate;
    }
}
