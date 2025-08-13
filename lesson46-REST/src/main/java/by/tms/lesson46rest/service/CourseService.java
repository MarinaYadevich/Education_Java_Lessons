package by.tms.lesson46rest.service;

import by.tms.lesson46rest.entity.CourseEntity;
import by.tms.lesson46rest.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseEntity> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<CourseEntity> getCourseById(UUID id){
        return courseRepository.findById(id);
    }

    public CourseEntity createCourse(CourseEntity courseEntity){
        return courseRepository.save(courseEntity);
    }

    public Optional<CourseEntity> updateCourse(UUID id, CourseEntity updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setDurationInDays(updatedCourse.getDurationInDays());
                    course.setPrice(updatedCourse.getPrice());
                    course.setActive(updatedCourse.isActive());
                    return courseRepository.save(course);
                });
    }

    public boolean deleteCourse(UUID id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
