package br.com.tony.controller;

import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.domain.Metadata;
import br.com.tony.service.person.producer.IRequestPersonData;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static br.com.tony.domain.HeaderName.CORRELATION_ID_HEADER_NAME;

@Controller(value = "/v1/orchestrator/card")
public class CardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);
    private final IRequestPersonData producerService;

    public CardController(IRequestPersonData producerService) {
        this.producerService = producerService;
    }

    @Post
    public HttpResponse<HttpStatus> create(@Body PersonRequest personRequest, HttpHeaders headers) {
        String correlationId = headers.get(CORRELATION_ID_HEADER_NAME);
        Metadata metadata = new Metadata();
        metadata.putHeader(CORRELATION_ID_HEADER_NAME, correlationId);
        LOGGER.info("CardRequest received with correlation-id: {}", correlationId);
        producerService.requestPersonData(personRequest, metadata);
        return HttpResponse.ok();
    }
}
