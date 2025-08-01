package by.tms.lesson43.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FilmDTO {

    private UUID id;

    @NotBlank(message = "{film.notblank}")
    @Size(min = 2, max = 50, message = "{film.title.size}")
    private String title;

    @NotBlank(message = "{film.notblank}")
    @Size(min = 2,max = 20, message = "{film.director.size}")
    private String director;

    @Min(value = 1895, message = "{film.year.size}")
    @Max(value = 2025, message = "{film.year.size}")
    private int year;

    private String description;


}
