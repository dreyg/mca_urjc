package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public Queue myQueue() {
        return new Queue("eoloplantCreationProgressNotifications", false);
    }

    /*@Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }*/

}
