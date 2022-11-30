package br.com.tony.service.impl;

import br.com.tony.client.dto.PersonProducerRequest;
import br.com.tony.client.producer.PersonProducer;
import br.com.tony.domain.Person;
import br.com.tony.domain.PersonDTO;
import br.com.tony.domain.client.RequestDTO;
import br.com.tony.repository.PersonRepository;
import br.com.tony.service.PersonService;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Singleton
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository;
    private final PersonProducer personProducer;

    public PersonServiceImpl(PersonRepository personRepository, PersonProducer personProducer) {
        this.personRepository = personRepository;
        this.personProducer = personProducer;
    }

    @Override
    public void processRequest(RequestDTO requestDTO) {
        Map<String, Object> headers = requestDTO.headers();
        LOGGER.info("Request with correlation-id {} received", headers.get("Correlation-Id"));
        PersonDTO personDTO = findById(requestDTO.id());
        PersonProducerRequest producerRequest = new PersonProducerRequest(
                personDTO.id(), personDTO.name(), personDTO.email(), personDTO.birthDate()
        );
        personProducer.sendPersonData(producerRequest, headers);
    }

    private PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElse(new Person());
        return new PersonDTO(person.getId(),
                person.getName(), person.getEmail(),
                person.getBirthDate());
    }
}
