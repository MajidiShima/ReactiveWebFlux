package ir.sharif.reactivewebflux.person_course;


import ir.sharif.reactivewebflux.course.Course;
import ir.sharif.reactivewebflux.course.CourseRepository;
import ir.sharif.reactivewebflux.person.Person;
import ir.sharif.reactivewebflux.person.PersonRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonCourseServiceImp implements IPersonCourseService {

    private final PersonRepository personRepository;
    private final CourseRepository courseRepository;
    private final PersonCourseRepository personCourseRepository;


    public PersonCourseServiceImp(PersonRepository personRepository, CourseRepository courseRepository, PersonCourseRepository personCourseRepository) {
        this.personRepository = personRepository;
        this.courseRepository = courseRepository;
        this.personCourseRepository = personCourseRepository;
    }


    @Override
    public Mono<PersonCourse> getPersonCourseById(int id) {
            return personCourseRepository.findById((long) id)
                    .switchIfEmpty(Mono.error(new ChangeSetPersister.NotFoundException("PersonCourse Not Found")))
                    .flatMap(personCourse -> {
                        Mono<Person> personMono = personCourse.getPersonId() != null ? personRepository.findById(personCourse.getPersonId()) : Mono.empty();
                        Mono<Course> courseMono = personCourse.getCourseId() != null ? courseRepository.findById(personCourse.getCourseId()) : Mono.empty();
                        return Mono.zip(personMono, courseMono)
                                .map(tuple -> {
                                    personCourse.setPerson(tuple.getT1());
                                    personCourse.setCourse(tuple.getT2());
                                    return personCourse;
                                });
                    });

    }

    @Override
    public Flux<PersonCourse> getPersonCourse() {
        return personCourseRepository.findAll();
    }

    @Override
    public Mono<PersonCourse> save(PersonCourse personCourse) {
        if(personCourse.getPerson()!=null && personCourse.getCourse()!=null){
            return personCourseRepository.save(personCourse);}
        else
            return Mono.error(new IllegalArgumentException("Person and Course cannot be null"));
    }
    @Override
    public Mono<PersonCourse> update(Long id, PersonCourse personCourse) {
        return personCourseRepository.findById(id)
                .flatMap(existingPersonCourse -> {
                    if (personCourse.getPerson() != null) {
                        existingPersonCourse.setPerson(personCourse.getPerson());
                    }
                    if (personCourse.getCourse() != null) {
                        existingPersonCourse.setCourse(personCourse.getCourse());
                    }
                    return personCourseRepository.save(existingPersonCourse);
                });
    }



    @Override
    public Mono<Void> delete(int id) {
        return personCourseRepository.deleteById((long) id);
    }
}
