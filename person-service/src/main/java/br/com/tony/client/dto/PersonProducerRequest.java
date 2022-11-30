package br.com.tony.client.dto;

import java.time.LocalDate;

public record PersonProducerRequest(Long id,
                                    String name,
                                    String email,
                                    LocalDate birthDate) {}
