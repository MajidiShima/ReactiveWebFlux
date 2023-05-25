package ir.sharif.reactivewebflux.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository repository;



    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/v1")
    public Flux<Person> getPerson() {
        return repository.findAll();
    }

}
