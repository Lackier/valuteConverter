package com.app.repository;

import com.app.model.Currency;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CurrenciesRepo extends CrudRepository<Currency, Long> {

    Iterable<Currency> findAll();

    Iterable<Currency> findAllByDate(LocalDate date);

    Optional<Currency> findByDateAndName(LocalDate date, String name);

    Optional<Currency> findById(Long id);

    Optional<Currency> findByDateAndCharCode(LocalDate date, String Code);
}
