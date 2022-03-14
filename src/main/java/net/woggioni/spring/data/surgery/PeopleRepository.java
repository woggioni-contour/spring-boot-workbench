package net.woggioni.spring.data.surgery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
