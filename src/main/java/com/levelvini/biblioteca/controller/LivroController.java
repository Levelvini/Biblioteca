package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.LivroDTO;
import com.levelvini.biblioteca.model.Livro;
import com.levelvini.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class LivroController {

    LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> fingAll(){
        List<LivroDTO> livroDTO = livroService.getAll();
        return ResponseEntity.ok(livroDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<LivroDTO>> findById(@PathVariable Long id){
        Optional<LivroDTO> livroDTO = livroService.getById(id);
        return ResponseEntity.ok(livroDTO);
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody LivroDTO livroDTO){
        livroService.save(livroDTO);
        return ResponseEntity.ok("o livro foi adicionado com sucesso");
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@Valid @RequestBody LivroDTO livroDTO){
        LivroDTO livroUpdated = livroService.update(id, livroDTO);
        return ResponseEntity.ok("O livro " + livroUpdated.name() + " foi atualizado!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
