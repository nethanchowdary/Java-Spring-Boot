package com.practice.demo.controller;

import com.practice.demo.entity.Product;
import com.practice.demo.entity.Users;
import com.practice.demo.service.UserServ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersRestController {

    @Autowired
    private UserServ userServ;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createUsers")
    public Users addUser(@RequestBody Users product){
        log.info("Inside create of user");
        return userServ.addUsers(product);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/findAllUsers")
    public List<Users> findAllUsers(){
        log.info("Inside findAll of user");
        return userServ.findAllUsers();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @PostMapping("/findUsersById/{id}")
    public Users findById(@PathVariable Long id){
        log.info("Inside findById of user");
        return userServ.findUserById(id);
    }

    @PostMapping("/addNote")
    public Product addProduct(@RequestBody Product farmer){
        return userServ.addProducts(farmer);
    }


}
