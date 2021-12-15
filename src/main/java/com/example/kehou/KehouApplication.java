package com.example.kehou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
//@ServletComponentScan(basePackages = "com.example.kehou.config.filter")
public class KehouApplication {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(KehouApplication.class, args);

//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(">>>>>>" + name);
//        }


    }

}
