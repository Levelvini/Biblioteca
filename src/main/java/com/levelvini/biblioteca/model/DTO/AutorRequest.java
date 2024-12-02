package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AutorRequest(
        Long id,
        @NotBlank(message = "é obrigatória a inserção do nome")
        String name,
        //@CPf
        @NotBlank(message = "é obrigatória a inserção do CPF")
        String CPF,
        Integer age,
        List<Livro> livros) {
}
