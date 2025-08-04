package by.tms.lesson43.repository;

import by.tms.lesson43.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, UUID>, JpaSpecificationExecutor<FilmEntity> {

    List<FilmEntity> findByTitle(String title);
}
