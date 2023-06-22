package ch.gibb.m165.backend.controller;

import ch.gibb.m165.backend.dtos.PersonDTO;
import ch.gibb.m165.backend.models.Person;
import ch.gibb.m165.backend.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/persons")
@CrossOrigin
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping()
    List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    Person get(@PathVariable String id) {
        return personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    Person newItem(@RequestBody PersonDTO personDTO) {
        return personRepository.save(new Person(UUID.randomUUID().toString(), personDTO.firstName(), personDTO.lastName(), personDTO.employment_lvl(), personDTO.is_male()));
    }

    @PutMapping("/{id}")
    Person updateItem(@PathVariable String id, @RequestBody PersonDTO personDTO) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        person.setFirstName(personDTO.firstName());
        person.setLastName(personDTO.lastName());
        person.setEmploymentLvl(personDTO.employment_lvl());
        person.setMale(personDTO.is_male());
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable String id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        personRepository.delete(person);
    }
}
