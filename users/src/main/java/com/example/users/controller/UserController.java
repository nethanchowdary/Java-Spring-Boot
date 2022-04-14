package com.example.users.controller;

import com.example.users.entity.User;
import com.example.users.service.IUserService;
import com.example.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
       return service.getUserById(id);
    }

}
