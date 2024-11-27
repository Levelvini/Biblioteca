package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LivroDTO(

        Long id,

        @NotBlank
        @Size(min = )
        String name,

        Autor autor,

        Categoria categoria) {
}
