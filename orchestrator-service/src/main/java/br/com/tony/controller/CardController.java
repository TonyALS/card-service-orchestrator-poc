package br.com.tony.controller;

import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.controller.header.HeaderName;
import br.com.tony.domain.Metadata;
import br.com.tony.service.PersonProducerService;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller(value = "/v1/orchestrator/card")
public class CardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);
    private final PersonProducerService producerService;

    public CardController(PersonProducerService producerService) {
        this.producerService = producerService;
    }

    @Post
    public HttpResponse<HttpStatus> create(@Body PersonRequest personRequest, HttpHeaders headers) {
        String correlationId = headers.get(HeaderName.CORRELATION_ID_HEADER_NAME);
        Metadata metadata = new Metadata();
        metadata.setCorrelationId(correlationId);
        LOGGER.info("CardRequest received. Correlation-Id: {}", correlationId);
        producerService.requestPersonData(personRequest, metadata);
        return HttpResponse.ok();
    }
}
