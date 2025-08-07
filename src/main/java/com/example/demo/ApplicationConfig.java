package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("bean1(Normal Profile)");
    }

    @Bean
    @Qualifier("bean2")
    //@Profile("dev")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("bean2(Developer profile)");
    }

}
