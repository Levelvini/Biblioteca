package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
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
    public List<LivroDTO> getAll(){
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()){
            throw new EmptyDataException("você ainda não possui livros cadastrados");
        }else {
            return Collections.singletonList(modelMapper.map(livros, LivroDTO.class));
        }
    }

    @Transactional
   public Optional<LivroDTO> getById(Long id){
       Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o livro não pôde ser encontrado"));
       return Optional.ofNullable(modelMapper.map(livro, LivroDTO.class));
   }

   @Transactional
   public Livro save(LivroDTO livroDTO){
     Livro livro = modelMapper.map(livroDTO, Livro.class);
     return livroRepository.save(livro);
   }

   @Transactional
   public LivroDTO update(Long id,LivroDTO livroDTO){
    Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O livro não pode ser encontrado"));
    modelMapper.map(livroDTO, livro);
    livro = livroRepository.save(livro);
    return modelMapper.map(livro,LivroDTO.class);
    }

    @Transactional
    public void delete(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o livro informado não existe"));
        livroRepository.delete(livro);
    }



}
