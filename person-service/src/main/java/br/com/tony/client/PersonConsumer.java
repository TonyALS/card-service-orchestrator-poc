package br.com.tony.client;

import br.com.tony.client.dto.PersonProducerRequest;
import br.com.tony.service.PersonService;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;

@RabbitListener
public class PersonConsumer {

    private final PersonService personService;

    public PersonConsumer(PersonService personService) {
        this.personService = personService;
    }

    @Queue(value = "person.data.request.queue")
    public void receivePersonData(PersonProducerRequest producerRequest) {
        personService.findById(producerRequest.clientId());
    }
}
