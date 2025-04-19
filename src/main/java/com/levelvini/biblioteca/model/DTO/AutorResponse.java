package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Livro;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class AutorResponse implements Serializable {
    private Long id;
    private String name;
    private int age;
    @Setter(value = AccessLevel.NONE)
    List<Long> livrosId;

    public AutorResponse(Long id, String name, int age, List<Long> livros) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.livrosId = livros;
    }

    public static AutorResponse toAutorResponse(Autor autor) {
        return new AutorResponse(
                autor.getId(),
                autor.getName(),
                autor.getAge(),
                autor.getLivros().stream().map(Livro::getId).collect(Collectors.toList())
        );
    }
}