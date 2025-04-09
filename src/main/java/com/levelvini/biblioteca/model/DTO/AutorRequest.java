package com.levelvini.biblioteca.model.DTO;

import com.levelvini.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorRequest implements Serializable {
        Long id;
        @NotBlank(message = "é obrigatória a inserção do nome")
        private String name;
        //@CPf
        @NotBlank(message = "é obrigatória a inserção do CPF")
        private String CPF;
        private Integer age;
        @Setter(value = AccessLevel.NONE)
        private List<Livro> livros;
}

