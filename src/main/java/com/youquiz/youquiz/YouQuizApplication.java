package com.youquiz.youquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class YouQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouQuizApplication.class, args);
    }

}
