package br.com.tony.domain;

import br.com.tony.client.dto.CardConsumerRequest;

import java.util.Map;

public record ProcessCardRequestDTO(CardConsumerRequest consumerRequest,
                                    Map<String, Object> headers) { }
