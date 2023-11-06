package com.youquiz.youquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.youquiz.youquiz.Repository"})
public class YouQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouQuizApplication.class, args);
    }

}
