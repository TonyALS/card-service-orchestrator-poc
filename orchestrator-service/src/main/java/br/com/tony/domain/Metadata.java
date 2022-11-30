package br.com.tony.domain;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    private final Map<String, Object> headers = new HashMap<>();

    public void putHeader(String k, Object v) {
        this.headers.put(k, v);
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }
}
