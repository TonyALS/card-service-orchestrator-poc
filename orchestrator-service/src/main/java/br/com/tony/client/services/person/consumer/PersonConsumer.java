package br.com.tony.client.services.person.consumer;

import br.com.tony.client.services.person.dto.PersonConsumerRequest;
import br.com.tony.domain.ProcessPersonResponseDTO;
import br.com.tony.service.person.consumer.IReceivePersonData;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static br.com.tony.domain.HeaderName.CORRELATION_ID_HEADER_NAME;

@RabbitListener
public class PersonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonConsumer.class);

    private final IReceivePersonData receivePersonData;

    public PersonConsumer(IReceivePersonData receivePersonData) {
        this.receivePersonData = receivePersonData;
    }

    @Queue(value = "person.data.response.queue")
    public void receivePersonData(PersonConsumerRequest consumerRequest,
                                  @RabbitHeaders Map<String, Object> headers) {
        LOGGER.info("Receive message with correlation-id {}", headers.get(CORRELATION_ID_HEADER_NAME));
        ProcessPersonResponseDTO responseDTO = new ProcessPersonResponseDTO(consumerRequest, headers);
        receivePersonData.processResponse(responseDTO);
    }
}
