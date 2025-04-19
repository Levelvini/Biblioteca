package com.levelvini.biblioteca.config;

import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.Livro;
import com.levelvini.biblioteca.repository.AutorRepository;
import com.levelvini.biblioteca.repository.CategoriaRepository;
import com.levelvini.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {
    LivroRepository livroRepository;
    AutorRepository autorRepository;
    CategoriaRepository categoriaRepository;

    @Autowired
    public InitialData(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Autor autor1 = new Autor(null, "Machado de assis", "123456", 48, null);
        Autor autor2 = new Autor(null, "Monteiro Lobato", "123456", 59, null);
        Autor autor3 = new Autor(null, "Willian Gibson", "123456", 74, null);
        Autor autor4 = new Autor(null, "George Orwell", "123456", 39, null);

        Categoria categoria1 = new Categoria(null, "Cyberpunk", null);
        Categoria categoria2 = new Categoria(null, "Suspense", null);
        Categoria categoria3 = new Categoria(null, "Fantasia", null);
        Categoria categoria4 = new Categoria(null, "Romance", null);

        Livro livro1 = new Livro(null, "Neuromancer", autor3, categoria1);
        Livro livro2 = new Livro(null, "Spraw", autor3, categoria1);
        Livro livro3 = new Livro(null, "Sitio do pica pau amarelo", autor2, categoria3);
        Livro livro4 = new Livro(null, "star wars", autor4, categoria1);
        Livro livro5 = new Livro(null, "a cartomante", autor1, categoria4);
        Livro livro6 = new Livro(null, "A revolução dos bichos", autor4, categoria2);

        autorRepository.save(autor1);
        autorRepository.save(autor2);
        autorRepository.save(autor3);
        autorRepository.save(autor4);

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);
        categoriaRepository.save(categoria4);

        livroRepository.save(livro1);
        livroRepository.save(livro2);
        livroRepository.save(livro3);
        livroRepository.save(livro4);
        livroRepository.save(livro5);
        livroRepository.save(livro6);

        //dados aleatórios
    }
}
