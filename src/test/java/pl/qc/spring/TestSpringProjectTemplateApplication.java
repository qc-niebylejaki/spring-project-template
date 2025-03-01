package pl.qc.spring;

import org.springframework.boot.SpringApplication;

public class TestSpringProjectTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringProjectTemplateApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
