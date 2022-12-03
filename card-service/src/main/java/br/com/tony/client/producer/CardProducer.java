package br.com.tony.client.producer;

import br.com.tony.client.dto.CardProducerRequest;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;

import java.util.Map;

@RabbitClient(value = "card.data.response")
public interface CardProducer {

    @Binding(value = "card.data.response.routing.key")
    void sendCardRequestData(CardProducerRequest cardProducerRequest,
                        @RabbitHeaders Map<String, Object> headers);
}
