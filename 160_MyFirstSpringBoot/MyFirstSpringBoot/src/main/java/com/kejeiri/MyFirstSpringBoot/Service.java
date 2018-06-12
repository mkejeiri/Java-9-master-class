package com.kejeiri.MyFirstSpringBoot;

//tell Spring that this is a service
@org.springframework.stereotype.Service
public class Service {
    public String showName(String name){
        return name;
    }
}
