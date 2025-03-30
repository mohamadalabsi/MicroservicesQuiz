package org.me.learning.quizmicros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizMIcroSApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizMIcroSApplication.class, args);
    }

}
