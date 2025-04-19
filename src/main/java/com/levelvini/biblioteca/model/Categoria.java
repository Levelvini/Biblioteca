package com.levelvini.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long Id;

    private String name;

    @OneToMany(mappedBy = "categoria")
    @Setter(AccessLevel.NONE)
    private List<Livro> livros;
}
