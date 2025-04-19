package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.model.DTO.AutorRequest;
import com.levelvini.biblioteca.model.DTO.AutorResponse;
import com.levelvini.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ("/autor"))
public class AutorController {

    public AutorService Service;

    public AutorController(AutorService autorService) {
        this.Service = autorService;
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> findAll() {
        return ResponseEntity.ok(Service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<AutorResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(Service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody AutorRequest autorRequest) {
        Service.save(autorRequest);
        return ResponseEntity.ok("O autor foi adicionado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody AutorRequest autorRequest) {
        AutorResponse autor = Service.update(id, autorRequest);
        return ResponseEntity.ok("O autor" + autor.getName() + " foi atualizado!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Service.delete(id);
        return ResponseEntity.ok().body("deletado com sucesso!!");
    }
}
