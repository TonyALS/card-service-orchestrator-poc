package br.com.tony.repository;

import br.com.tony.domain.CardRequest;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ICardRepository extends JpaRepository<CardRequest, Long> { }
