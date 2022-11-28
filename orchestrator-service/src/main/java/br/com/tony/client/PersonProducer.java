package br.com.tony.client;

import br.com.tony.client.dto.PersonProducerRequest;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient(value = "person.data.request")
public interface PersonProducer {
    @Binding(value = "person.data.request.routing.key")
    void requestPersonData(PersonProducerRequest producerRequest);
}
