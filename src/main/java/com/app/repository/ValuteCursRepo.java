package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.model.Valute;

import java.util.Date;
import java.util.Optional;

public interface ValuteCursRepo extends CrudRepository<Valute, Long>{

    Iterable<Valute> findAllByDate(Date date);

    Optional<Valute> findByDateAndName(Date date, String name);
    Optional<Valute> findById(Long id);

}
