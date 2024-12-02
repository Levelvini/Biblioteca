package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Livro;

import java.util.List;

public record AutorResponse(
        Long id,
        String name,
        int age,
        List<Livro> livros) {
//    public AutorResponse toAutor(Autor autor){
//        return new AutorResponse(autor.getId(), autor.getName(), autor.getAge(), autor.getLivros());
//    }
}
