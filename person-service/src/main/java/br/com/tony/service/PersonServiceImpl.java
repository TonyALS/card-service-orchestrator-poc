package br.com.tony.service;

import br.com.tony.domain.Person;
import br.com.tony.domain.PersonDTO;
import br.com.tony.repository.PersonRepository;
import jakarta.inject.Singleton;

@Singleton
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElse(new Person());
        return new PersonDTO(person.getId(), person.getName(), person.getEmail(), person.getBirthDate());
    }
}
