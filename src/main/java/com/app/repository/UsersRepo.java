package com.app.repository;

import com.app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<User, Long> {
}
