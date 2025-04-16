package com.levelvini.biblioteca.controller;


import com.levelvini.biblioteca.model.DTO.CategoriaRequest;
import com.levelvini.biblioteca.model.DTO.CategoriaResponse;
import com.levelvini.biblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    public CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaResponse>> findAll(){
        List<CategoriaResponse> categoria = categoriaService.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<CategoriaResponse>> findById(@PathVariable Long id){
        Optional<CategoriaResponse> categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody CategoriaRequest categoriaRequest){
        categoriaService.save(categoriaRequest);
        return ResponseEntity.ok("Categoria salva com sucesso!!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@Valid @RequestBody CategoriaRequest categoriaRequest){
        CategoriaResponse categoria = categoriaService.update(id, categoriaRequest);
        return ResponseEntity.ok("A categoria foi atualizada!!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!!");
    }
}
