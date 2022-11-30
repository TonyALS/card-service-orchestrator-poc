package br.com.tony.client.consumer;

import br.com.tony.client.dto.PersonConsumerRequest;
import br.com.tony.domain.client.RequestDTO;
import br.com.tony.service.PersonService;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;
import io.micronaut.rabbitmq.annotation.RabbitListener;

import java.util.Map;

@RabbitListener
public class PersonConsumer {

    private final PersonService personService;

    public PersonConsumer(PersonService personService) {
        this.personService = personService;
    }

    @Queue(value = "person.data.request.queue")
    public void receivePersonData(PersonConsumerRequest consumerRequest,
                                  @RabbitHeaders Map<String, Object> headers) {
        personService.processRequest(new RequestDTO(consumerRequest.clientId(), headers));
    }
}
