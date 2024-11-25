package br.fsa.viniciuspinho.microservices.estudante_service.service;

import br.fsa.viniciuspinho.microservices.estudante_service.entity.Estudante;
import br.fsa.viniciuspinho.microservices.estudante_service.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante addEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> fetchEstudante() {
        return estudanteRepository.findAll();
    }

    public Estudante fetchEstudanteById(int id) {
        return estudanteRepository.findById((long) id).orElse(null);
    }

    public boolean deleteEstudanteById(int id) {
        Optional<Estudante> user = estudanteRepository.findById((long) id);
        if (user.isPresent()) {
            estudanteRepository.deleteById((long) id);
            return true;
        } else {
            return false;
        }
    }

    public void updateEstudante(Estudante estudante) {
        // Verifica se o estudante existe no banco antes de atualizar
        if (estudante.getId() != null && estudanteRepository.existsById(estudante.getId())) {
            estudanteRepository.save(estudante); // Atualiza o estudante
        } else {
            throw new IllegalArgumentException("Estudante não encontrado ou ID inválido!");
        }
    }

    public Optional<Estudante> fetchEstudanteWithCurso(Long id) {
        // Busca o estudante com os detalhes do curso
        return estudanteRepository.fetchEstudanteWithCurso(id);
    }
}
