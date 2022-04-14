package com.example.taskmongo.service;
import com.example.taskmongo.dto.EmployeeDetails;
import com.example.taskmongo.entity.Employee;
import com.example.taskmongo.exception.EmployeeNotFoundException;
import com.example.taskmongo.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SequenceGeneratorService generatorService;

   public Employee addEmployee(EmployeeDetails employee){
       Employee em=new Employee();
       em.setUserid(generatorService.generateSequence("emp_sequence"));
       em.setFullName(employee.getFullName());
       em.setUserName(employee.getUserName());
       em.setAddress(employee.getAddress());
       em.setMobileNumber(employee.getMobileNumber());
       em.setCurrentOrganization(employee.getCurrentOrganization());
       em.setEmailId(employee.getEmailId());
       log.info("Inside Add Employee of service");
        return employeeRepo.save(em);
    }

    public Employee getByUserName(String username){
        log.info("Inside get user by username of service");
        return employeeRepo.findByUserName(username);
    }

    public void deleteByUserName(String username){
        log.info("Inside delete by username of service");
       employeeRepo.deleteByUserName(username);
    }
    
    public Employee updateByUserName( String username){
       log.info("Inside update by username of service");
       Employee employee= employeeRepo.findByUserName(username);
       String fullName= employee.getFullName();
        String spclChars="!@#$%^&*()_+=-[]{}';:><?/.,";
        Random random=new Random();
        int randomInt=random.nextInt(spclChars.length());
        String randomChar=Character.toString(spclChars.charAt(randomInt));
        String output=fullName.replaceAll("[aeiouAEIOU]",randomChar);
       employee.setFullName(output);
       return employeeRepo.save(employee);
    }
}
