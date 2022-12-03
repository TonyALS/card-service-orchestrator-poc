package br.com.tony.client.consumer;

import br.com.tony.client.dto.CardConsumerRequest;
import br.com.tony.domain.ProcessCardRequestDTO;
import br.com.tony.service.IProcessCardRequest;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitHeaders;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static br.com.tony.domain.HeaderName.CORRELATION_ID_HEADER_NAME;

@RabbitListener
public class CardConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CardConsumer.class);

    private final IProcessCardRequest processCardRequest;

    public CardConsumer(IProcessCardRequest processCardRequest) {
        this.processCardRequest = processCardRequest;
    }

    @Queue(value = "card.data.request.queue")
    public void receivePersonData(CardConsumerRequest consumerRequest,
                                  @RabbitHeaders Map<String, Object> headers) {
        LOGGER.info("Received message with correlation-id {}", headers.get(CORRELATION_ID_HEADER_NAME));
        ProcessCardRequestDTO cardRequestDTO = new ProcessCardRequestDTO(consumerRequest, headers);
        processCardRequest.processCardRequest(cardRequestDTO, headers);
    }
}
