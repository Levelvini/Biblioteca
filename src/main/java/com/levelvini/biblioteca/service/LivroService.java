package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import com.levelvini.biblioteca.model.DTO.LivroRequest;
import com.levelvini.biblioteca.model.DTO.LivroResponse;
import com.levelvini.biblioteca.model.Livro;
import com.levelvini.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    public LivroRepository repository;
    public ModelMapper modelMapper;

    public LivroService(LivroRepository livroRepository, ModelMapper modelMapper) {
        this.repository = livroRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<LivroResponse> getAll() {
        List<Livro> livros = repository.findAll();
        if (livros.isEmpty()) {
            throw new EmptyDataException("você ainda não possui livros cadastrados");
        } else {
            return Collections.singletonList(modelMapper.map(livros, LivroResponse.class));
        }
    }

    @Transactional
    public Optional<LivroResponse> getById(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o livro não pôde ser encontrado"));
        return Optional.ofNullable(modelMapper.map(livro, LivroResponse.class));
    }

    @Transactional
    public Livro save(LivroRequest livroRequest) {
        Livro livro = modelMapper.map(livroRequest, Livro.class);
        return repository.save(livro);
    }

    @Transactional
    public LivroResponse update(Long id, LivroRequest livroRequest) {
        Livro livro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O livro não pode ser encontrado"));
        modelMapper.map(livroRequest, livro);
        livro = repository.save(livro);
        return modelMapper.map(livro, LivroResponse.class);
    }

    @Transactional
    public void delete(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o livro informado não existe"));
        repository.delete(livro);
    }
}
