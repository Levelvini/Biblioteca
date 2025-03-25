package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Livro;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorResponse implements Serializable{
    private Long id;
    private String name;
    private int age;
    @Setter(value = AccessLevel.NONE)
    private List<Livro> livros;
}