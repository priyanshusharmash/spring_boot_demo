package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/*
@PropertySource("classpath:custom.properties")
@Service
public class MyFirstService {
    private final MyFirstClass myFirstClass;
    @Value("${owner.name}")
    private String ownerName;
    @Value("${profile.type}")
    private String profileType;
    public MyFirstService(
            @Qualifier("bean2") MyFirstClass myFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }
    public String showMessage(){
        return "Service is saying"+ myFirstClass.sayHello();
    }
    public String getOwnerName(){return ownerName;}

    public String getActiveProfile(){ return profileType;}

}

 */
