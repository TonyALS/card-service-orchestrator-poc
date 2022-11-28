package br.com.tony.domain;

import java.time.LocalDate;

public record PersonDTO(
        Long id,
        String name,
        String email,
        LocalDate birthDate) { }
