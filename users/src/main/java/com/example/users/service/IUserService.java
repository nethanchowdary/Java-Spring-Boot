package com.example.users.service;

import com.example.users.entity.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface IUserService {
    User addUser(@NotNull @Valid User user);
    User getUserById(@NotNull @Min(1) Long id);
}
