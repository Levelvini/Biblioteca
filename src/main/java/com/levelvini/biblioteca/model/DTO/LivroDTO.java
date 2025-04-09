package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Categoria;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable{
                Long id;
                @NotEmpty(message = "o campo nome não pode ser vazio")
                @Size(min = 3,message = "a quantidade minima de caracteres deve ser igual ou maior que 3")
                String name;
                Autor autor;
                Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
