package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.LivroDTO;
import com.levelvini.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LivroController {

    LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    public ResponseEntity<Optional<LivroDTO>> getById(@RequestParam Long id){
        Optional<LivroDTO> livroDTO = livroService.getById(id);
        return ResponseEntity.ok(livroDTO);
    }
}
