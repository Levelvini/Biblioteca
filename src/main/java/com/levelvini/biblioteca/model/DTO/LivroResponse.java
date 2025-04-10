package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroResponse {
    private Long id;
    private String name;
    private Long autorId;
    private Long CategoriaId;

    public LivroResponse(Long id, String name, Autor autorId, Categoria categoriaId) {
        this.id = id;
        this.name = name;
        this.autorId = autorId.getId();
        this.CategoriaId = categoriaId.getId();
    }
}
