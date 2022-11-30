package br.com.tony.service.impl;

import br.com.tony.client.producer.PersonProducer;
import br.com.tony.client.dto.PersonProducerRequest;
import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.domain.Metadata;
import br.com.tony.service.PersonProducerService;
import jakarta.inject.Singleton;

@Singleton
public class PersonProducerServiceImpl implements PersonProducerService {

    private final PersonProducer personProducer;

    public PersonProducerServiceImpl(PersonProducer personProducer) {
        this.personProducer = personProducer;
    }

    @Override
    public void requestPersonData(PersonRequest personRequest, Metadata metadata) {
        PersonProducerRequest producerRequest = new PersonProducerRequest(personRequest.clientId());
        personProducer.requestPersonData(producerRequest, metadata.getHeaders());
    }
}
