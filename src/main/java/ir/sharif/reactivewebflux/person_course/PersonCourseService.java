package ir.sharif.reactivewebflux.person_course;


import org.example.course.CourseRepository;
import org.example.person.PersonRepository;
import org.springframework.stereotype.Service;


@Service
public class PersonCourseService {

private final CourseRepository courseRepository;
private final PersonRepository personRepository;
private final PersonCourseRepository personCourseRepository;


    public PersonCourseService(CourseRepository courseRepository, PersonRepository personRepository, PersonCourseRepository personCourseRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
        this.personCourseRepository = personCourseRepository;
    }






}
