package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.LivroDTO;
import com.levelvini.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAll(){
        List<LivroDTO> livroDTO = livroService.getAll();
        return ResponseEntity.ok(livroDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<LivroDTO>> getById(@PathVariable Long id){
        Optional<LivroDTO> livroDTO = livroService.getById(id);
        return ResponseEntity.ok(livroDTO);
    }


}
