package pl.tstawowy.calendar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.tstawowy.calendar.services.UtilityService;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    User user;
    String name;
    String color;
    //Set<Day> days;

    public String getColor() {
        if (color == null || color.length() != 6 || !color.matches("[0-9A-F]{6}")) {
            String newColor = UtilityService.generateColor(id);
            setColor(newColor);
            return newColor;
        }
        else {
            return color;
        }
    }

}
