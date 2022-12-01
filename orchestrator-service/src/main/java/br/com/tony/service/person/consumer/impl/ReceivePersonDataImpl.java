package br.com.tony.service.person.consumer.impl;

import br.com.tony.domain.ProcessPersonResponseDTO;
import br.com.tony.service.person.consumer.IReceivePersonData;
import jakarta.inject.Singleton;

@Singleton
public class ReceivePersonDataImpl implements IReceivePersonData {

    @Override
    public void processResponse(ProcessPersonResponseDTO responseDTO) {
        //  TODO
    }
}
