package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.model.DTO.LivroDTO;
import com.levelvini.biblioteca.model.Livro;
import com.levelvini.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    public LivroRepository livroRepository;

//    public List<LivroDTO> buscarTodos(){
//        List<Livro> livro = livroRepository.findAll();
//        return new
//    }
}
