package br.fsa.viniciuspinho.microservices.estudante_service.estudante_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.fsa.viniciuspinho.microservices.estudante_service")
@EnableJpaRepositories(basePackages = "br.fsa.viniciuspinho.microservices.estudante_service.repository")
@EntityScan(basePackages = "br.fsa.viniciuspinho.microservices.estudante_service.entity")
public class EstudanteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudanteServiceApplication.class, args);
	}

}