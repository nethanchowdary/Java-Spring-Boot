package com.practice.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Product {

    @GeneratedValue
    @Id
    private Long notesId;
    @Length(max=20, min=2)
    private String titleName;
//    @ElementCollection
//    private Set<Long> userIds;
}
