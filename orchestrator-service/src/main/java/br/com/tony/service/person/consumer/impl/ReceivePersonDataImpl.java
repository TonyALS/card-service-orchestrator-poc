package br.com.tony.service.person.consumer.impl;

import br.com.tony.client.services.card.dto.CardProducerRequest;
import br.com.tony.domain.ProcessPersonResponseDTO;
import br.com.tony.service.card.producer.IRequestCard;
import br.com.tony.service.person.consumer.IReceivePersonData;
import jakarta.inject.Singleton;

@Singleton
public class ReceivePersonDataImpl implements IReceivePersonData {

    private final IRequestCard requestCard;

    public ReceivePersonDataImpl(IRequestCard requestCard) {
        this.requestCard = requestCard;
    }

    @Override
    public void processResponse(ProcessPersonResponseDTO responseDTO) {
        CardProducerRequest cardProducerRequest = new CardProducerRequest(responseDTO.getPersonConsumerRequest().id());
        requestCard.requestCard(cardProducerRequest, responseDTO.getMetadata());
    }
}
