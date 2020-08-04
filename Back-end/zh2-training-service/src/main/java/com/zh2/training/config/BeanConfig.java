package com.zh2.training.config;

import com.zh2.training.domain.message.Creditor;
import com.zh2.training.domain.message.Debitor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Creditor creditor(){
        return new Creditor();
    }
    @Bean
    public Debitor debitor(){
        return new Debitor();
    }
}
