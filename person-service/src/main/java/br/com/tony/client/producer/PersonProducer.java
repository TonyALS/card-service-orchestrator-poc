package br.com.tony.client.producer;

import br.com.tony.client.dto.PersonProducerRequest;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;

import java.util.Map;

@RabbitClient(value = "person.data.response")
public interface PersonProducer {
    @Binding(value = "person.data.response.routing.key")
    void sendPersonData(PersonProducerRequest producerRequest,
                        @RabbitHeaders Map<String, Object> headers);
}
