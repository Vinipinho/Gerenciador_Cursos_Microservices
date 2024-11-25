package br.fsa.viniciuspinho.microservices.curso_service.curso_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.fsa.viniciuspinho.microservices.curso_service")
@EnableJpaRepositories(basePackages = "br.fsa.viniciuspinho.microservices.curso_service.repository")
@EntityScan(basePackages = "br.fsa.viniciuspinho.microservices.curso_service.entity")
public class CursoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServiceApplication.class, args);
	}

}
