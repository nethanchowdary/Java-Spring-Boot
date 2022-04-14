package com.example.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDetails {
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    private List<String> notesTitle;


}
