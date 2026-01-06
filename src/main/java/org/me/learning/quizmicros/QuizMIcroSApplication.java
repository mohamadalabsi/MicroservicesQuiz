package org.me.learning.quizmicros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // we enable it here because we used it here but ofcource whenwe use it in
// other place we should enable it in other services
public class QuizMIcroSApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizMIcroSApplication.class, args);
    }

}
