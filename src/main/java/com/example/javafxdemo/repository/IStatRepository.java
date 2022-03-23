package com.example.javafxdemo.repository;

import com.example.javafxdemo.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IStatRepository extends JpaRepository<Stat, Long> {

}
