package br.com.tony.domain.client;

import java.util.Map;

public record RequestDTO(Long id, Map<String, Object> headers) {}
