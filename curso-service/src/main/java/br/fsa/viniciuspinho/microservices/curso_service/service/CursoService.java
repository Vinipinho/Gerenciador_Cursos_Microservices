package br.fsa.viniciuspinho.microservices.curso_service.service;

import br.fsa.viniciuspinho.microservices.curso_service.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.fsa.viniciuspinho.microservices.curso_service.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> fetchAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso fetchCursoById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso addCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public boolean deleteCursoById(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void updateCurso(Curso curso) {
        if (curso.getId() != null && cursoRepository.existsById(curso.getId())) {
            cursoRepository.save(curso);
        } else {
            throw new IllegalArgumentException("Curso não encontrado ou ID inválido!");
        }
    }

    public Optional<Curso> fetchCursoWithInstrutor(Long instrutorId) {
        List<Curso> cursos = cursoRepository.fetchCursosByInstrutorId(instrutorId);
        if (!cursos.isEmpty()) {
            return Optional.of(cursos.get(0));
        }
        return Optional.empty();
    }
}
