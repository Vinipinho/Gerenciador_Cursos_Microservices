package br.fsa.viniciuspinho.microservices.instrutor_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instrutor")

public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String especialidade;
    private String nome;

    private Long cursoId; // ID do curso no banco compartilhado


}
