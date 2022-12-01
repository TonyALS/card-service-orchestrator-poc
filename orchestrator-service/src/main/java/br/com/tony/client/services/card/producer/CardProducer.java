package br.com.tony.client.services.card.producer;

import br.com.tony.client.services.person.dto.PersonProducerRequest;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;

import java.util.Map;

@RabbitClient(value = "card.data.request")
public interface CardProducer {
    @Binding(value = "card.data.request.routing.key")
    void requestPersonData(PersonProducerRequest producerRequest, @RabbitHeaders Map<String, Object> headers);
}
