package by.tms.lesson46rest.controller;

import by.tms.lesson46rest.entity.CourseEntity;
import by.tms.lesson46rest.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable UUID id) {
        Optional<CourseEntity> courseEntity = courseService.getCourseById(id);
        if (courseEntity.isPresent()) {
            return ResponseEntity.ok(courseEntity.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseEntity course) {
        CourseEntity created = courseService.createCourse(course);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public CourseEntity updateCourse(@PathVariable UUID id, @RequestBody CourseEntity course) {
        return courseService.updateCourse(id, course)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable UUID id) {
        boolean deleted = courseService.deleteCourse(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
    }

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        List<CourseEntity> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
