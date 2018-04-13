package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class VehicleBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleBackEndApplication.class, args);
    }
}
