package com.example.kehou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class KehouApplication {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(KehouApplication.class, args);

//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(">>>>>>" + name);
//        }


    }

}
