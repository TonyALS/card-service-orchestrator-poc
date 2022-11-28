package br.com.tony.service;

import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.domain.Metadata;

public interface PersonProducerService {
    void requestPersonData(PersonRequest personRequest, Metadata metadata);
}
