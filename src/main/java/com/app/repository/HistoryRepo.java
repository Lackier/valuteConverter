package com.app.repository;

import com.app.model.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepo extends CrudRepository<History, Long> {
    Iterable<History> findAllByUserId(int userId);
}
