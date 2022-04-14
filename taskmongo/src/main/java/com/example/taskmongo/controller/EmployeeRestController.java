package com.example.taskmongo.controller;

import com.example.taskmongo.dto.EmployeeDetails;
import com.example.taskmongo.entity.Employee;
import com.example.taskmongo.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeRestController {

    @Autowired
    private Service service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeDetails employee){
        log.info("Inside Add Employee Controller");
        return service.addEmployee(employee);
    }

    @DeleteMapping("/deleteByUsername")
    public void deleteEmployee(@RequestParam(name = "username") String username){
        log.info("Inside delete Employee Controller");
        service.deleteByUserName(username);
    }

    @PutMapping("/replaceVowelsWithSpecialChars")
    public Employee updateEmployee( @RequestParam(name = "username") String username){
        log.info("Inside Update Employee Controller");
        return service.updateByUserName(username);
    }

    @GetMapping("/username")
    public Employee getByUsername(@RequestParam(name = "username") String username){
        log.info("Inside get user by username Controller");
        return service.getByUserName(username);
    }

    @GetMapping("/numVowels")
    public long numOfVowels(@RequestParam(name = "input") String input){
        log.info("Inside Controller of counting number of vowels and Special characters");
        int vowels=0, specialchars=0,consonants=0,digit=0;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='A'&& ch<='Z')) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
            else if(ch>='0' && ch<='9')
                digit++;
            else
                specialchars++;
        }
        return vowels+specialchars;
    }
}