package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import com.levelvini.biblioteca.model.Autor;
import com.levelvini.biblioteca.model.DTO.AutorRequest;
import com.levelvini.biblioteca.model.DTO.AutorResponse;
import com.levelvini.biblioteca.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {
    AutorRepository repository;
    ModelMapper modelMapper;

    public AutorService(AutorRepository autorRepository, ModelMapper modelMapper) {
        this.repository = autorRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<AutorResponse> getAll() {
        List<Autor> autorResponse = repository.findAll();
        List<AutorResponse> autorResponseList = autorResponse.stream().map(AutorResponse::toAutorResponse).collect(Collectors.toList());
        if (autorResponse.isEmpty()) {
            throw new EmptyDataException("você ainda não possui autores cadastrados");
        } else {
            return autorResponseList;
        }
    }

    @Transactional
    public Optional<AutorResponse> getById(Long id) {
        Autor autor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado"));
        return Optional.of(AutorResponse.toAutorResponse(autor));
    }

    @Transactional
    public AutorResponse save(AutorRequest autorRequest) {
        Autor autor = modelMapper.map(autorRequest, Autor.class);
        Autor autorReturn = repository.save(autor);
        return AutorResponse.toAutorResponse(autorReturn);
    }

    @Transactional
    public AutorResponse update(Long id, AutorRequest autorRequest) {
        Autor autor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o autor a ser aualizado não foi encontrado"));
        modelMapper.map(autorRequest, autor);
        Autor autorReturn = repository.save(autor);
        return AutorResponse.toAutorResponse(autorReturn);
    }

    @Transactional
    public void delete(Long id) {
        Autor autor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("este autor não pôde ser encontrado"));
        repository.delete(autor);
    }
}







