package br.fsa.viniciuspinho.microservices.curso_service.controller;

import br.fsa.viniciuspinho.microservices.curso_service.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.fsa.viniciuspinho.microservices.curso_service.service.CursoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/curso")
@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> fetchAllCursos(){
        return cursoService.fetchAllCursos();
    }

    @PostMapping("/add")
    public Curso addCurso(@RequestBody Curso curso) {
        return cursoService.addCurso(curso);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCursoById(@PathVariable Long id) {
        boolean isDeleted = cursoService.deleteCursoById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Curso deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCurso(@RequestBody Curso curso) {
        try {
            cursoService.updateCurso(curso);
            return ResponseEntity.ok("Curso atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
