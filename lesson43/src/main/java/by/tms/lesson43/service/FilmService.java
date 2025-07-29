package by.tms.lesson43.service;

import by.tms.lesson43.model.FilmDTO;

import java.util.List;


public interface FilmService {

    void save(FilmDTO filmDTO);

    List<FilmDTO> findAll();

    List<FilmDTO> findFilmByTitle(String title);
}
