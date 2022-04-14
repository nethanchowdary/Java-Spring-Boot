package com.example.taskmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDetails {

    private String userName;
    private String fullName;
    private String emailId;
    private String address;
    private long mobileNumber;
    private String currentOrganization;
}
