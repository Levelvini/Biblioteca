package com.levelvini.biblioteca.controller;


import com.levelvini.biblioteca.model.DTO.CategoriaDTO;
import com.levelvini.biblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    public CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> categoria = categoriaService.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<CategoriaDTO>> findById(@PathVariable Long id){
        Optional<CategoriaDTO> categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody CategoriaDTO categoriaDTO){
        categoriaService.save(categoriaDTO);
        return ResponseEntity.ok("Categoria salva com sucesso!!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = categoriaService.update(id,categoriaDTO);
        return ResponseEntity.ok("A categoria foi atualizada!!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!!");
    }
}
