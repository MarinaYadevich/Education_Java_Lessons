package by.tms.lesson43.specification;

import by.tms.lesson43.entity.FilmEntity;
import by.tms.lesson43.model.FilmSearchDTO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FilmSpecifications {

    public static Specification<FilmEntity> createSpecification(FilmSearchDTO dto) {
        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            //поиск по названию(Полное совпадение)
            if (dto.getTitle() != null && !dto.getTitle().isBlank()){
                predicates.add(builder.or(builder.equal(root.get("title"), dto.getTitle())));
            }

            //поиск по описанию(частичное совпадение)
            if (dto.getDescription() != null && !dto.getDescription().isBlank()) {
                String pattern = "%" + dto.getDescription().toLowerCase() + "%";
                predicates.add(builder.like(builder.lower(root.get("description")), pattern));
            }

            //поиск по количеству страниц от
            if (dto.getPageCountFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("pageCount"), dto.getPageCountFrom()));
            }

            // поиск по количеству страниц до
            if (dto.getPageCountTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("pageCount"), dto.getPageCountTo()));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
