package br.com.tony.service.card.producer.impl;

import br.com.tony.client.services.card.dto.CardProducerRequest;
import br.com.tony.client.services.card.producer.CardProducer;
import br.com.tony.service.card.producer.IRequestCard;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class RequestCardImpl implements IRequestCard {

    private final CardProducer cardProducer;

    public RequestCardImpl(CardProducer cardProducer) {
        this.cardProducer = cardProducer;
    }

    @Override
    public void requestCard(CardProducerRequest cardRequest, Map<String, Object> metadata) {
        CardProducerRequest cardProducerRequest = new CardProducerRequest(cardRequest.clientId());
        cardProducer.requestCardData(cardProducerRequest, metadata);
    }
}
