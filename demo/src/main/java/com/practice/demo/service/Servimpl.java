package com.practice.demo.service;

import com.practice.demo.Exceptions.UserNotFoundException;
import com.practice.demo.dao.ProductRepo;
import com.practice.demo.dao.UserRepo;
import com.practice.demo.entity.Product;
import com.practice.demo.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Servimpl implements UserServ {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Users addUsers(Users product) {
        log.info("Inside addUsers of service");
        return userRepo.save(product);
    }

    @Override
    public List<Users> findAllUsers() {
        log.info("Inside findAllUsers of service");
        return userRepo.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        log.info("Inside findUserById of service");
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found for id: "+id));
    }

    @Override
    public Product addProducts(Product farmer) {
        return productRepo.save(farmer);
    }

}




