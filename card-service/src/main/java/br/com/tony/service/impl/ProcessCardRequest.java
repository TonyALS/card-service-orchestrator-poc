package br.com.tony.service.impl;

import br.com.tony.client.dto.CardProducerRequest;
import br.com.tony.client.producer.CardProducer;
import br.com.tony.domain.CardRequest;
import br.com.tony.domain.CardRequestStatus;
import br.com.tony.domain.ProcessCardRequestDTO;
import br.com.tony.repository.ICardRepository;
import br.com.tony.service.IProcessCardRequest;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class ProcessCardRequest implements IProcessCardRequest {

    private final ICardRepository cardRepository;

    private final CardProducer cardProducer;

    public ProcessCardRequest(ICardRepository cardRepository, CardProducer cardProducer) {
        this.cardRepository = cardRepository;
        this.cardProducer = cardProducer;
    }

    @Override
    public void processCardRequest(ProcessCardRequestDTO cardReqDTO, Map<String, Object> headers) {
        CardRequest cardRequest = new CardRequest(cardReqDTO.consumerRequest().clientId(),
                CardRequestStatus.CARD_REQUEST_UNDER_ANALYSIS.ordinal());

        CardRequest request = cardRepository.save(cardRequest);
        sendCardRequestResponse(request, headers);
    }

    private void sendCardRequestResponse(CardRequest cardRequest, Map<String, Object> headers) {
        CardProducerRequest producerRequest = new CardProducerRequest(
                cardRequest.getId(),
                cardRequest.getCustomerId(),
                cardRequest.getRequestStatus()
        );
        cardProducer.sendCardRequestData(producerRequest, headers);
    }
}
