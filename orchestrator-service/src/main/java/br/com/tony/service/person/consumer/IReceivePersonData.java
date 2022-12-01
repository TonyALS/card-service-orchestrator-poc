package br.com.tony.service.person.consumer;

import br.com.tony.domain.ProcessPersonResponseDTO;

public interface IReceivePersonData {
    void processResponse(ProcessPersonResponseDTO responseDTO);
}
