package by.tms.lesson43.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Film {

    @NotBlank(message = "Пожалуйста, заполните поле")
    @Size(min = 2, max = 50, message = "Название должно быть не более 50 символов")
    private String title;

    @NotBlank(message = "Пожалуйста, заполните поле")
    @Size(min = 2,max = 20, message = "Название должно быть не более 20 символов")
    private String director;

    @Min(value = 1895, message = "Год должен быть от 1895 до 2025")
    @Max(value = 2025, message = "Год должен быть от 1895 до 2025")
    private int year;
}
