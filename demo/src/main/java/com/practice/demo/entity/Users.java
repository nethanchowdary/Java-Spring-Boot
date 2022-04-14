package com.practice.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @GeneratedValue
    @Id
    private Long userId;
    @Length(max=20, min=2)
    private String firstName;
    @Length(max=20, min=2)
    private String lastName;
    @NotBlank
    private String Address;

}
