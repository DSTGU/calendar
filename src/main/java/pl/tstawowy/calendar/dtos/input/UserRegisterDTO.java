package pl.tstawowy.calendar.dtos.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterDTO {

    @NotEmpty(message = "Login nie może być pusty")
    @Size(min = 4, max = 32, message = "Login musi mieć od 4 do 32 znaków")
    private String login;

    @NotEmpty(message = "Hasło nie może być puste")
    @Size(min = 8, max = 128, message = "Hasło musi mieć od 8 do 128 znaków")
    private String password;

    @NotEmpty(message = "Hasło nie może być puste")
    @Size(min = 8, max = 128, message = "Hasło musi mieć od 8 do 128 znaków")
    private String repeatPassword;
}
