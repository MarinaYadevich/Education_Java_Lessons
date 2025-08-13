package by.tms.lesson46rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseEntity {

    @Id
    @UuidGenerator()
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int durationInDays;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean active;
}
