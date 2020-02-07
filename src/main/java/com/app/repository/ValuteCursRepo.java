package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.model.Valute;

import java.util.Date;

public interface ValuteCursRepo extends CrudRepository<Valute, Long>{

    Iterable<Valute> findAllByDate(Date date);
    Iterable<Valute> findAllByDateAndName(Date date, String name);

}
