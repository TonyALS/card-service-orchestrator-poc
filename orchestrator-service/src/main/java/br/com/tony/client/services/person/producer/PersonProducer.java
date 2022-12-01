package br.com.tony.client.services.person.producer;

import br.com.tony.client.services.person.dto.PersonProducerRequest;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;

import java.util.Map;

@RabbitClient(value = "person.data.request")
public interface PersonProducer {
    @Binding(value = "person.data.request.routing.key")
    void requestPersonData(PersonProducerRequest producerRequest, @RabbitHeaders Map<String, Object> headers);
}
