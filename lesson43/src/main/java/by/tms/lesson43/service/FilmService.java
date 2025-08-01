package by.tms.lesson43.service;

import by.tms.lesson43.entity.FilmEntity;
import by.tms.lesson43.model.FilmDTO;
import by.tms.lesson43.model.FilmSearchDTO;

import java.util.List;

public interface FilmService {

    void save(FilmDTO filmDTO);

    List<FilmDTO> findAll();

    List<FilmDTO> findFilmByTitle(String title);

    List<FilmEntity> searchFilms(FilmSearchDTO dto);
}
