package com.practice.demo.service;

import com.practice.demo.entity.Product;
import com.practice.demo.entity.Users;

import java.util.List;

public interface UserServ {

    Users addUsers(Users product);


    List<Users> findAllUsers();

    Users findUserById(Long id);

    Product addProducts(Product farmer);

}
