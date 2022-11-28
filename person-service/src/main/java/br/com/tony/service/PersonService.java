package br.com.tony.service;

import br.com.tony.domain.PersonDTO;

public interface PersonService {
    PersonDTO findById(Long id);
}
