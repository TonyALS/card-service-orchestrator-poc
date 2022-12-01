package br.com.tony.client.services.person.consumer;

import br.com.tony.client.services.person.dto.PersonConsumerRequest;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;
import io.micronaut.rabbitmq.annotation.RabbitListener;

import java.util.Map;

@RabbitListener
public class PersonConsumer {

    @Queue(value = "person.data.response.queue")
    public void receivePersonData(PersonConsumerRequest consumerRequest,
                                  @RabbitHeaders Map<String, Object> headers) {
        System.out.println("Person Data: " + consumerRequest);
        System.out.println("Headers: " + headers.toString());
    }
}
