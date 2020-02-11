package com.app.repository;

import com.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepo extends CrudRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

}
