package ir.sharif.reactivewebflux.person_course;


import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person-course")
public class PersonCourseController {


    @GetMapping("/api/data")
    public Flux<String> getData() {
        // تولید و برگشت یک Flux ریکتیو
        return Flux.just("Data 1", "Data 2", "Data 3");
    }

    @GetMapping("/api/random")
    public Mono<Integer> getRandomNumber() {
        // تولید و برگشت یک Mono ریکتیو
        return Mono.fromSupplier(() -> generateRandomNumber());
    }

    private Integer generateRandomNumber() {
        // تولید یک عدد صحیح تصادفی
        return ThreadLocalRandom.current().nextInt();
    }










}
