package edu.homeauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class HomeAutoStartup {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HomeAutoStartup.class, args);
    }
}
