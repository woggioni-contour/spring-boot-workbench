package net.woggioni.spring.data.surgery;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PeopleFactory {
    private static final Logger log = LoggerFactory.getLogger(PeopleFactory.class);

    private final PeopleRepository peopleRepository;

    @PostConstruct
    void doSomething() {
        Person person = new Person();
        person.setName("John");
        person.setSurname("Doe");
        person.setAge(25);
        peopleRepository.save(person);

        List<Person> people = peopleRepository.findAll();

        people.forEach(p -> {
            log.info("{}", p);
        });
    }
}
