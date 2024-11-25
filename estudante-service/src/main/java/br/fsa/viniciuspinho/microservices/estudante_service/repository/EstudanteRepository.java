package br.fsa.viniciuspinho.microservices.estudante_service.repository;

import br.fsa.viniciuspinho.microservices.estudante_service.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {
    @Query("SELECT e FROM Estudante e WHERE e.id = :id")
    Optional<Estudante> fetchEstudanteWithCurso(Long id);
}