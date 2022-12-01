package br.com.tony.service.person.producer;

import br.com.tony.controller.dto.PersonRequest;
import br.com.tony.domain.Metadata;

public interface IRequestPersonData {
    void requestPersonData(PersonRequest personRequest, Metadata metadata);
}
