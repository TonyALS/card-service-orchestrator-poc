package br.com.tony.service;

import br.com.tony.domain.ProcessCardRequestDTO;

import java.util.Map;

public interface IProcessCardRequest {
    void processCardRequest(ProcessCardRequestDTO cardReqDTO, Map<String, Object> headers);
}
