package br.com.tony.domain;

import br.com.tony.client.services.person.dto.PersonConsumerRequest;

import java.util.Map;

public class ProcessPersonResponseDTO {
    private final PersonConsumerRequest personConsumerRequest;
    private final Map<String, Object> headers;

    public ProcessPersonResponseDTO(PersonConsumerRequest personConsumerRequest, Map<String, Object> headers) {
        this.personConsumerRequest = personConsumerRequest;
        this.headers = headers;
    }

    public PersonConsumerRequest getPersonConsumerRequest() {
        return personConsumerRequest;
    }

    public Map<String, Object> getMetadata() {
        return headers;
    }
}
