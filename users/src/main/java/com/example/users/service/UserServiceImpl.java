package com.example.users.service;

import com.example.users.dao.IUserRepository;
import com.example.users.entity.User;
import com.example.users.exceptions.UserNotFoundException;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> optional=userRepository.findById(id);
        if(!optional.isPresent()){
            throw  new UserNotFoundException("User is not found for the id : "+id);
        }
        return optional.get();
    }
}
