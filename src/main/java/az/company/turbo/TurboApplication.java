package az.company.turbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

public class TurboApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurboApplication.class, args);
    }

}
