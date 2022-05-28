package com.example.javafxdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String city;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;
}
