package br.com.tony.service.impl;

import br.com.tony.domain.CardRequest;
import br.com.tony.domain.CardRequestStatus;
import br.com.tony.domain.ProcessCardRequestDTO;
import br.com.tony.repository.ICardRepository;
import br.com.tony.service.IProcessCardRequest;
import jakarta.inject.Singleton;

@Singleton
public class ProcessCardRequest implements IProcessCardRequest {

    private final ICardRepository cardRepository;

    public ProcessCardRequest(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void processCardRequest(ProcessCardRequestDTO cardReqDTO) {
        CardRequest cardRequest = new CardRequest(cardReqDTO.consumerRequest().clientId(),
                CardRequestStatus.CARD_REQUEST_UNDER_ANALYSIS.ordinal());

        CardRequest request = cardRepository.save(cardRequest);
    }
}
