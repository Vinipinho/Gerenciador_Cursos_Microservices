package br.fsa.viniciuspinho.microservices.instrutor_service.repository;




import br.fsa.viniciuspinho.microservices.instrutor_service.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor,Long> {
    @Query("SELECT e FROM Instrutor e WHERE e.id = :id")
    Optional<Instrutor> fetchInstrutorWithCurso(Long id);
}
