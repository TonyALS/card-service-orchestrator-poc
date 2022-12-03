package br.com.tony.service.card.producer;

import br.com.tony.client.services.card.dto.CardProducerRequest;
import br.com.tony.domain.Metadata;

import java.util.Map;

public interface IRequestCard {
    void requestCard(CardProducerRequest cardRequest, Map<String, Object> metadata);
}
