package com.example.taskmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="user")
public class Employee {
    @Transient
    public static final String SEQUENCE_NAME = "emp_sequence";

    @Id
    private long userid;
    private String userName;
    private String fullName;
    private String emailId;
    private String address;
    private long mobileNumber;
    private String currentOrganization;
}
