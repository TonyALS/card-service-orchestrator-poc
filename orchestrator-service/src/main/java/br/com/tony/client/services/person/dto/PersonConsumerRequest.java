package br.com.tony.client.services.person.dto;

import java.time.LocalDate;

public record PersonConsumerRequest(Long id,
                                    String name,
                                    String email,
                                    LocalDate birthDate) {}
