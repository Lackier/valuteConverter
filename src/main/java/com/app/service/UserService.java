package com.app.service;

import com.app.model.User;
import com.app.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UsersRepo usersRepo;

    public User findByLogin(String login){
        Optional<User> user = usersRepo.findUserByLogin(login);
        return user.orElse(null);
    }

    public boolean exists(String login){
        return usersRepo.findUserByLogin(login).isPresent();
    }
}
