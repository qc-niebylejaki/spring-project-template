package pl.qc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "pl.qc.spring")
public class SpringProjectTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectTemplateApplication.class, args);
    }

}
