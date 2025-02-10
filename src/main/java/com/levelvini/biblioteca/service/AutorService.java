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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    AutorRepository autorRepository;
    ModelMapper modelMapper;

    public AutorService(AutorRepository autorRepository, ModelMapper modelMapper) {
        this.autorRepository = autorRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<AutorResponse> getAll(){
        List<Autor> autorResponse = autorRepository.findAll();
        if (autorResponse.isEmpty()){
            throw new EmptyDataException("você ainda não possui autores cadastrados");
        }else {
            return Collections.singletonList(modelMapper.map(autorResponse, AutorResponse.class));
        }
    }

    @Transactional
    public Optional<AutorResponse> getById(Long id){
        Autor autor = autorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Autor não encontrado"));
        return Optional.of(modelMapper.map(autor, AutorResponse.class));
    }

    @Transactional
    public Autor save(AutorRequest autorRequest){
        Autor autor = modelMapper.map(autorRequest, Autor.class);
        return autorRepository.save(autor);
    }

    @Transactional
    public Autor update(Long id, AutorRequest autorRequest){
        Autor autor = autorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("o autor a ser aualizado não foi encontrado"));
        modelMapper.map(autorRequest, autor);
        return autorRepository.save(autor);
  }

  @Transactional
  public void delete(Long id){
        Autor autor = autorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("este autor não pôde ser encontrado"));
        autorRepository.delete(autor);
  }
}







