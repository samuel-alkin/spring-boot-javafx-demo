package com.example.javafxdemo;

import com.example.javafxdemo.entity.Stat;
import com.example.javafxdemo.repository.IStatRepository;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootifulApplication {

    public static void main(String[] args) {
        Application.launch(FXApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(IStatRepository repository) {
        return (args) -> {
            // save a couple of Stats
            repository.save(new Stat(1L, "Stat1"));
            repository.save(new Stat(2L, "Stat2"));
        };
    }

}
