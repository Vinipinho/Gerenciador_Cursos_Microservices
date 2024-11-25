package br.fsa.viniciuspinho.microservices.instrutor_service.service;

import br.fsa.viniciuspinho.microservices.instrutor_service.entity.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.fsa.viniciuspinho.microservices.instrutor_service.repository.InstrutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {
    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor addInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public List<Instrutor> fetchInstrutor() {
        return instrutorRepository.findAll();
    }

    public Instrutor fetchInstrutorById(int id) {
        return instrutorRepository.findById((long) id).orElse(null);
    }

    public boolean deleteInstrutorById(int id) {
        Optional<Instrutor> user = instrutorRepository.findById((long) id);
        if (user.isPresent()) {
            instrutorRepository.deleteById((long) id);
            return true;
        } else {
            return false;
        }
    }

    public void updateInstrutor(Instrutor instrutor) {
        // Verifica se o instrutor existe no banco antes de atualizar
        if (instrutor.getId() != null && instrutorRepository.existsById(instrutor.getId())) {
            instrutorRepository.save(instrutor); // Atualiza o instrutor
        } else {
            throw new IllegalArgumentException("Instrutor não encontrado ou ID inválido!");
        }
    }
    public Optional<Instrutor> fetchInstrutorWithCurso(Long id) {
        // Busca o estudante com os detalhes do curso
        return instrutorRepository.fetchInstrutorWithCurso(id);
    }

}
