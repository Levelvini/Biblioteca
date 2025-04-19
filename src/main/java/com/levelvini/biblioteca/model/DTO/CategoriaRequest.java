package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest implements Serializable {
    private Long id;
    @NotBlank(message = "o nome deve ser preenchido")
    @Size(min = 3, message = "o nome deve conter mais de 3 caracteres")
    private String name;
    @Setter(value = AccessLevel.NONE)
    List<Livro> livros;
}
