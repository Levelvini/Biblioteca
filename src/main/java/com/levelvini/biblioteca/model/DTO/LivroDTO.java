package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LivroDTO(

        Long id,
        @NotBlank(message = "o campo nome não pode ser vazio")
        @Size(min = 3,message = "a quantidade minima de caracteres deve ser igual ou maior que 3")
        String name,
        Autor autor,
        Categoria categoria) {
//        public Livro toLivro(LivroDTO livroDTO){
//                return new Livro(id,name,autor,categoria);
//        }
}
