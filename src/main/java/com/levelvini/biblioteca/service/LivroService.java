package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import com.levelvini.biblioteca.model.DTO.LivroDTO;
import com.levelvini.biblioteca.model.Livro;
import com.levelvini.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    public LivroRepository livroRepository;
    public ModelMapper modelMapper;

    @Autowired
    public LivroService(LivroRepository livroRepository, ModelMapper modelMapper) {
        this.livroRepository = livroRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Optional<List<LivroDTO>> getAll(){
        Optional<List<Livro>> livros = Optional.of(livroRepository.findAll());
        return Optional.of(Collections.singletonList(modelMapper.map(livros, LivroDTO.class)));
        //retorna uma List imutavel!
    }

    @Transactional
   public Optional<LivroDTO> getById(Long id){
       Optional<Livro> livro = livroRepository.findById(id);
       return Optional.ofNullable(modelMapper.map(livro, LivroDTO.class));
   }

   @Transactional
   public Livro save(LivroDTO livroDTO){
     Livro livro = modelMapper.map(livroDTO, Livro.class);
     return livroRepository.save(livro);
   }

   @Transactional
   public Livro update(Long id,LivroDTO livroDTO){
    Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O livro não pode ser encontrado"));
    modelMapper.map(livroDTO, livro);
    return livroRepository.save(livro);
    }

    @Transactional
    public void delete(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o livro informado não existe"));
        livroRepository.delete(livro);
    }
}
