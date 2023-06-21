package ch.gibb.m165.backend.repositories;

import ch.gibb.m165.backend.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

}
