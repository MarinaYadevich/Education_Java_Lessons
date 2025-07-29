package by.tms.lesson43.mapper;

import by.tms.lesson43.entity.FilmEntity;
import by.tms.lesson43.model.FilmDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    FilmEntity toEntity(FilmDTO filmDTO);

    FilmDTO toDTO(FilmEntity filmEntity);

    List<FilmDTO> toDTO(List<FilmEntity> filmEntities);

    List<FilmEntity> toEntity(List<FilmDTO> filmDTOs);
}
