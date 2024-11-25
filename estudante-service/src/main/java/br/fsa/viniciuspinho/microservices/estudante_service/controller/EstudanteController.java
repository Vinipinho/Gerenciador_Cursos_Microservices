package br.fsa.viniciuspinho.microservices.estudante_service.controller;

import br.fsa.viniciuspinho.microservices.estudante_service.entity.Estudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.fsa.viniciuspinho.microservices.estudante_service.service.EstudanteService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/estudante")
@RestController
public class EstudanteController {
    @Autowired
    private EstudanteService estudanteService;

    @PostMapping("/add")
    public Estudante addEstudante(@RequestBody Estudante estudante){
        return estudanteService.addEstudante(estudante);
    }

    @GetMapping
    public List<Estudante> fetchEstudante(){
        return  estudanteService.fetchEstudante();
    }

    @GetMapping("/{id}")
    public Estudante fetchEstudantebyId(@PathVariable int id){
        return estudanteService.fetchEstudanteById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEstudanteById(@PathVariable int id) {
        boolean isDeleted = estudanteService.deleteEstudanteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEstudante(@RequestBody Estudante estudante) {
        try {
            estudanteService.updateEstudante(estudante);
            return ResponseEntity.ok("Estudante atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}/detalhes")
    public ResponseEntity<Estudante> fetchEstudanteWithCurso(@PathVariable Long id) {
        Optional<Estudante> estudante = estudanteService.fetchEstudanteWithCurso(id);
        if (estudante.isPresent()) {
            return ResponseEntity.ok(estudante.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
