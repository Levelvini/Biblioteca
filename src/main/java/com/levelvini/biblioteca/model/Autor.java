package com.levelvini.biblioteca.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //@CPF
    private String CPF;

    private Integer age;

    @OneToMany(mappedBy = "autor")
    @Setter(AccessLevel.NONE)
    public List<Livro> livros;

}
