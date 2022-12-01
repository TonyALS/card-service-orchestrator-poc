package br.com.tony.service.person.producer.impl;

import br.com.tony.client.services.person.producer.PersonProducer;
import br.com.tony.client.services.person.dto.PersonProducerRequest;
import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.domain.Metadata;
import br.com.tony.service.person.producer.IRequestPersonData;
import jakarta.inject.Singleton;

@Singleton
public class RequestPersonDataImpl implements IRequestPersonData {

    private final PersonProducer personProducer;

    public RequestPersonDataImpl(PersonProducer personProducer) {
        this.personProducer = personProducer;
    }

    @Override
    public void requestPersonData(PersonRequest personRequest, Metadata metadata) {
        PersonProducerRequest producerRequest = new PersonProducerRequest(personRequest.clientId());
        personProducer.requestPersonData(producerRequest, metadata.getHeaders());
    }
}
