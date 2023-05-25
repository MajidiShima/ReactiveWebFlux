package ir.sharif.reactivewebflux.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Course> createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping("/")
    public Flux<Course> getCourse() {
        return courseRepository.findAll();
    }


}
