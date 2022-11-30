package br.com.tony.client.dto;

import java.time.LocalDate;

public record PersonConsumerRequest(Long id,
                                    String name,
                                    String email,
                                    LocalDate birthDate) {}
