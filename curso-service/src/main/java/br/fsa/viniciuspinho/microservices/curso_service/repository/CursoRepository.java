package br.fsa.viniciuspinho.microservices.curso_service.repository;

import br.fsa.viniciuspinho.microservices.curso_service.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
    // Consulta personalizada para buscar cursos por instrutorId
    @Query("SELECT c FROM Curso c WHERE c.instrutorId = :instrutorId")
    List<Curso> fetchCursosByInstrutorId(@Param("instrutorId") Long instrutorId);
}
