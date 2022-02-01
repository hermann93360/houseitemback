package com.example.houseitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class HouseitemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseitemApplication.class, args);
    }

}
