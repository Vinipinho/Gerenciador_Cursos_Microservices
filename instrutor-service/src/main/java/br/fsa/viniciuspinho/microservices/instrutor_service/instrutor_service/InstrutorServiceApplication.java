package br.fsa.viniciuspinho.microservices.instrutor_service.instrutor_service;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.fsa.viniciuspinho.microservices.instrutor_service")
@EnableJpaRepositories(basePackages = "br.fsa.viniciuspinho.microservices.instrutor_service.repository")
@EntityScan(basePackages = "br.fsa.viniciuspinho.microservices.instrutor_service.entity")
public class InstrutorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstrutorServiceApplication.class, args);
    }

}

