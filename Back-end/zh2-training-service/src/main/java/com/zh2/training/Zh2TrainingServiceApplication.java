package com.zh2.training;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zh2.training.infrastructure.repository")
public class Zh2TrainingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Zh2TrainingServiceApplication.class, args);
    }

}
