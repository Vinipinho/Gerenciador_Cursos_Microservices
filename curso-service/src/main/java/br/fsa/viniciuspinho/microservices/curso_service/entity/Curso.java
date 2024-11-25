package br.fsa.viniciuspinho.microservices.curso_service.entity;

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
@Table(name = "curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int duracao;
    private String nome;
    private String descricao;

    private Long instrutorId;
}
