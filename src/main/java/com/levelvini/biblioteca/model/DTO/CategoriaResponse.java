package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CategoriaResponse {
    private Long id;
    private String name;
    private List<Long> livrosId;

    public CategoriaResponse(Long id, String name, List<Long> livrosId) {
        this.id = id;
        this.name = name;
        this.livrosId = livrosId;
    }

    public static CategoriaResponse toCategoriaResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId(),
                categoria.getName(),
                categoria.getLivros().stream().map(Livro::getId).collect(Collectors.toList()));
    }
}
