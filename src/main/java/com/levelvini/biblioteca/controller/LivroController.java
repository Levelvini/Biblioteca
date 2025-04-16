package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.LivroRequest;
import com.levelvini.biblioteca.model.DTO.LivroResponse;
import com.levelvini.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> fingAll(){
        List<LivroResponse> livroDTO = livroService.getAll();
        return ResponseEntity.ok(livroDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<LivroResponse>> findById(@PathVariable Long id){
        Optional<LivroResponse> livroDTO = livroService.getById(id);
        return ResponseEntity.ok(livroDTO);
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody LivroRequest livroRequest){
        livroService.save(livroRequest);
        return ResponseEntity.ok("o livro foi adicionado com sucesso");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@Valid @RequestBody LivroRequest livroRequest){
        LivroResponse livroUpdated = livroService.update(id, livroRequest);
        return ResponseEntity.ok("O livro " + livroUpdated.getName() + " foi atualizado!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
