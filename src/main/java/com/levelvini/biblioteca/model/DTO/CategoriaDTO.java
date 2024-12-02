package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CategoriaDTO(
        Long id,
        @NotBlank(message = "o nome deve ser preenchido")
        @Size(min = 3,message = "o nome deve conter mais de 3 caracteres")
        String name,
        List<Livro> livros) {
//        public Categoria toCategoria(CategoriaDTO categoriaDTO){
//                return new Categoria(id,name,livros);
//        }
}
