package br.fsa.viniciuspinho.microservices.instrutor_service.controller;


import br.fsa.viniciuspinho.microservices.instrutor_service.entity.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.fsa.viniciuspinho.microservices.instrutor_service.service.InstrutorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/instrutor")
@RestController
public class InstrutorController {
    @Autowired
    private InstrutorService instrutorService;

    @PostMapping("/add")
    public Instrutor addInstrutor(@RequestBody Instrutor instrutor){
        return instrutorService.addInstrutor(instrutor);
    }

    @GetMapping
    public List<Instrutor> fetchInstrutor(){
        return  instrutorService.fetchInstrutor();
    }

    @GetMapping("/{id}")
    public Instrutor fetchInstrutorbyId(@PathVariable int id){
        return instrutorService.fetchInstrutorById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstrutorById(@PathVariable int id) {
        boolean isDeleted = instrutorService.deleteInstrutorById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateInstrutor(@RequestBody Instrutor instrutor) {
        try {
            instrutorService.updateInstrutor(instrutor);
            return ResponseEntity.ok("Instrutor atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<Instrutor> fetchInstrutorWithCurso(@PathVariable Long id) {
        Optional<Instrutor> instrutor = instrutorService.fetchInstrutorWithCurso(id);
        if (instrutor.isPresent()) {
            return ResponseEntity.ok(instrutor.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}