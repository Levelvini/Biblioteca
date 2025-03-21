package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.AutorRequest;
import com.levelvini.biblioteca.model.DTO.AutorResponse;
import com.levelvini.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ("/autor"))
public class AutorController {

    public AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> findAll(){
        List<AutorResponse> autorResponse =  autorService.getAll();
        return ResponseEntity.ok(autorResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<AutorResponse>> findById(@PathVariable Long id){
        Optional<AutorResponse> autorResponse = autorService.getById(id);
        return ResponseEntity.ok(autorResponse);
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody AutorRequest autorRequest){
        autorService.save(autorRequest);
        return ResponseEntity.ok("O autor foi adicionado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody AutorRequest autorRequest){
        AutorResponse autor = autorService.update(id, autorRequest);
        return ResponseEntity.ok("O autor" + autor.name() + " foi atualizado!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        autorService.delete(id);
        return ResponseEntity.ok().body("deletado com sucesso!!");
    }
}
