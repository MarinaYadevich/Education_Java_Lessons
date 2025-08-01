package by.tms.lesson43.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FilmSearchDTO {
    private String title;
    private String description;
    private Integer pageCountFrom;
    private Integer pageCountTo;
}
