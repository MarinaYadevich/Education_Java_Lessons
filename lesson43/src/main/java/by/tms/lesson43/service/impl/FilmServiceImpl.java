package by.tms.lesson43.service.impl;

import by.tms.lesson43.entity.FilmEntity;
import by.tms.lesson43.mapper.FilmMapper;
import by.tms.lesson43.model.FilmDTO;
import by.tms.lesson43.model.FilmSearchDTO;
import by.tms.lesson43.repository.FilmRepository;
import by.tms.lesson43.service.FilmService;
import by.tms.lesson43.specification.FilmSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    @Override
    public void save(FilmDTO filmDTO) {
        var entity = filmMapper.toEntity(filmDTO);
        filmRepository.save(entity);
    }

    @Override
    public List<FilmDTO> findAll() {
        var allEntity = filmRepository.findAll();
        var allDto = filmMapper.toDTO(allEntity);
        return allDto;
    }

    @Override
    public List<FilmDTO> findFilmByTitle(String title) {
        var foundEntities = filmRepository.findByTitle(title);
        var foundDto = filmMapper.toDTO(foundEntities);
        return foundDto;
    }

    @Override
    public List<FilmEntity> searchFilms(FilmSearchDTO dto) {
        return filmRepository.findAll(FilmSpecifications.createSpecification(dto));
    }


}
