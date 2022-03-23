package com.example.javafxdemo.service;

import com.example.javafxdemo.repository.IStatRepository;
import com.example.javafxdemo.entity.Stat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatService implements IStatService {

    private final IStatRepository statRepository;

    public StatService(IStatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public List<Stat> getStatList() {
        return statRepository.findAll();
    }

}
