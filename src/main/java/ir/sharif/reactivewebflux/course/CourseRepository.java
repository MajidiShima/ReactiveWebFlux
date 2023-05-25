package ir.sharif.reactivewebflux.course;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course,Long> {

}
