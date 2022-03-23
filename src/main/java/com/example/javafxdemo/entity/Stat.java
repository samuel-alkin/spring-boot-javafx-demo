package com.example.javafxdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Stat {

    @Id
    private Long id;

    private String value;

    public Stat() {

    }
}
