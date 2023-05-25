package ir.sharif.reactivewebflux.person_course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonCourseService {

    Mono<PersonCourse> getPersonCourseById(int id);
    Flux<PersonCourse> getPersonCourse();
    Mono<PersonCourse> save(PersonCourse personCourse);
    Mono<PersonCourse> update(Long id, PersonCourse personCourse);
    Mono<Void> delete(int id);


}
