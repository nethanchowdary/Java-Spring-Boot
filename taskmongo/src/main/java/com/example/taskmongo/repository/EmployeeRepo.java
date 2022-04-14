package com.example.taskmongo.repository;

import com.example.taskmongo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,Long> {
    void deleteByUserName(String username);

    Employee findByUserName(String username);
}
