package com.example.javafxdemo.repository;

import com.example.javafxdemo.entity.StatLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatLineRepository extends JpaRepository<StatLine, Long> {
}
