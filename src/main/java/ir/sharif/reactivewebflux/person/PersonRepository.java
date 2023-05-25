package ir.sharif.reactivewebflux.person;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person,Long> {
}
