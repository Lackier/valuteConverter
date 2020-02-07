package com.app.repository;

import com.app.model.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface CurrenciesRepo extends CrudRepository<Currency, Long>{

    Iterable<Currency> findAll();
    Iterable<Currency> findAllByDate(Date date);

    Optional<Currency> findByDateAndName(Date date, String name);
    Optional<Currency> findById(Long id);

}
