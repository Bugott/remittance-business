package com.intern.test01service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Test01ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test01ServiceApplication.class, args);
    }

}
