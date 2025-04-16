package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import com.levelvini.biblioteca.model.Categoria;
import com.levelvini.biblioteca.model.DTO.CategoriaRequest;
import com.levelvini.biblioteca.model.DTO.CategoriaResponse;
import com.levelvini.biblioteca.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    public CategoriaRepository categoriaRepository;
    public ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<CategoriaResponse> findAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaResponse> categoriaResponseList = categorias.stream().map(CategoriaResponse::toCategoriaResponse).collect(Collectors.toList());
        if (categorias.isEmpty()){
            throw new EmptyDataException("você ainda não possui categorias cadastradas");
        }else {
            return categoriaResponseList;
        }
    }

    @Transactional
    public Optional<CategoriaResponse> findById(Long id){
       Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("a categoria não pôde ser encontrada"));
       return Optional.of(CategoriaResponse.toCategoriaResponse(categoria));
    }

    @Transactional
    public CategoriaResponse save(CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaRequest, Categoria.class));
        return CategoriaResponse.toCategoriaResponse(categoria);
    }

    @Transactional
    public CategoriaResponse update(Long id, CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("o objeto a ser atualiza não foi encontrado"));
        modelMapper.map(categoriaRequest, categoria);
        Categoria categoriaUpdated = categoriaRepository.save(categoria);
        return CategoriaResponse.toCategoriaResponse(categoriaUpdated);
    }

    @Transactional
    public void delete(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("a categoria não foi encontrada"));
        categoriaRepository.delete(categoria);
    }
}
