package net.woggioni.spring.data.surgery;


import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@Import(PeopleTest.Config.class)
@ImportAutoConfiguration(JpaRepositoriesAutoConfiguration.class)
@AutoConfigurationPackage
@TestPropertySource("classpath:application.properties")
@DataJpaTest(excludeAutoConfiguration = {LiquibaseAutoConfiguration.class, FlywayAutoConfiguration.class})
public class PeopleTest {

    @Configuration
    public static class Config { }

    @Getter
    @Setter
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void test() {
        PeopleRepository repo = getPeopleRepository();
        Person person = new Person();
        person.setName("John");
        person.setSurname("Doe");
        person.setAge(25);
        repo.save(person);
    }
}
